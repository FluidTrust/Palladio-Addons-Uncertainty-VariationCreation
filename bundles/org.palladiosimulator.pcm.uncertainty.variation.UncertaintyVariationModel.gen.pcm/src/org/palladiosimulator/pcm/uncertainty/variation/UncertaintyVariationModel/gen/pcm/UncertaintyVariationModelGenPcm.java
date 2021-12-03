package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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
import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.VaryingAllocationContext;

public class UncertaintyVariationModelGenPcm {
	public UncertaintyVariationModelGenPcm(String baseUri) {
		this.modelBaseUri = baseUri + "/models";
		this.variationManager = new VariationManager(baseUri);
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
	
	public void generateVariations(IProgressMonitor progressMonitor) {
		final UncertaintyVariations variantions = loadModel(); /* VariationManager.loadVariantsModel */
        //VariationModellManger.setKnownVariantModels("allocation", "usageModel");
		
		//Iterator
		int variationPoint = 0;
		VaryingAllocationContext varAlloc = (VaryingAllocationContext)variantions.getVariationPoints().get(variationPoint);
		progressMonitor.beginTask("creating variations", varAlloc.getTargetResourceVariations().size());
		for (int i = 0; i < varAlloc.getTargetResourceVariations().size(); ++i) {
            try {
				variationManager.createCurrVariant(i, progressMonitor);
				//map<ModellType, list<EObject>> models = VariationManager.loadCurrVariantModels();

				ResourceAbstraction allocRes = new AllocationResourceAbstraction();

				this.alloc = (Allocation)allocRes.load(this.variationManager.getCurrScenatioUri() + "/portAllocation");
				ResourceContainer resCon = resolve(this.alloc.getTargetResourceEnvironment_Allocation(), varAlloc.getTargetResourceVariations().get(i));
				patchAllocationContext(varAlloc.getAllocationContext(), resCon);
				allocRes.save(this.variationManager.getCurrScenatioUri() + "/portAllocation", this.alloc);
				//VariationManager.storeCurrVariantModels(models);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		progressMonitor.done();
	}
	
	private VariationManager variationManager;
	private String modelBaseUri;
	private Allocation alloc;

}
