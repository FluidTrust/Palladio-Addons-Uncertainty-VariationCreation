package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.pcm.AllocationResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.pcm.RepositoryResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.pcm.ResourceEnvironmentResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.pcm.SystemResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.pcm.UsageResourceAbstraction;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.VaryingAllocationContext;

public class UncertaintyVariationModelGenPcm {
	public UncertaintyVariationModelGenPcm(String baseUri) {
		this.modelBaseUri = baseUri + "/models";
		this.scenarioBaseUri = baseUri + "/scenario";
	}
	
	//Factory Method, Definition state space, state iterator (list<tuple<VariantPoint, currVar>>)
	private UncertaintyVariations loadModel() {
		UncertaintyVariationModelPackage.eINSTANCE.eClass();
		
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getContentTypeToFactoryMap();
		m.put("uncertaintyvariationmodel", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(URI.createURI(this.modelBaseUri + "/port.uncertaintyvariationmodel"), true);
		
		UncertaintyVariations secVar = (UncertaintyVariations) res.getContents().get(0);
		return secVar;
	}
	
	//?
	private void patchAllocationContext(final AllocationContext allocCon, final ResourceContainer resCon) {
		for (AllocationContext it: this.alloc.getAllocationContexts_Allocation()) {
			if (it.getId().equalsIgnoreCase(allocCon.getId())) {
				it.setResourceContainer_AllocationContext(resCon);
			}
		}
	}
	
	private ResourceContainer resolve(ResourceEnvironment resEnv, ResourceContainer resCon) {
		ResourceContainer resolved = null;
		for (ResourceContainer it: resEnv.getResourceContainer_ResourceEnvironment()) {
			if (it.getId().equalsIgnoreCase(resCon.getId())) {
				resolved = it;
				break;
			}
		}
		
		return resolved;
	} 
	
	public void generateVariations() {
		final UncertaintyVariations variantions = loadModel();
		
		//Iterator
		int variationPoint = 0;
		VaryingAllocationContext varAlloc = (VaryingAllocationContext)variantions.getVariationPoints().get(variationPoint);
		for (int i = 0; i < varAlloc.getTargetResourceVariations().size(); ++i) {
			String scenarioUri = this.scenarioBaseUri + "/configuration_" + i;
			
			ResourceAbstraction allocRes = new AllocationResourceAbstraction();
			ResourceAbstraction resEnvRes = new ResourceEnvironmentResourceAbstraction();
			ResourceAbstraction repRes = new RepositoryResourceAbstraction();
			ResourceAbstraction sysRes = new SystemResourceAbstraction();
			ResourceAbstraction usageRes = new UsageResourceAbstraction();
			allocRes.copy(scenarioUri, this.modelBaseUri + "/portAllocation");
			resEnvRes.copy(scenarioUri, this.modelBaseUri + "/portHardware");
			repRes.copy(scenarioUri, this.modelBaseUri + "/portSystem");
			sysRes.copy(scenarioUri, this.modelBaseUri + "/portSystem");
			usageRes.copy(scenarioUri, this.modelBaseUri + "/portUsageModel");
			
			
			this.alloc = (Allocation)allocRes.load(scenarioUri + "/portAllocation");
			ResourceContainer resCon = resolve(this.alloc.getTargetResourceEnvironment_Allocation(), varAlloc.getTargetResourceVariations().get(i));
			patchAllocationContext(varAlloc.getAllocationContext(), resCon);
			allocRes.save(scenarioUri + "/portAllocation", this.alloc);
		}
	}
	
	private String modelBaseUri;
	private String scenarioBaseUri;
	private Allocation alloc;

}
