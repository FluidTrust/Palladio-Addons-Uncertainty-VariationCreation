package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.VaryingAllocationContext;

public class UncertaintyVariationModelGenPcm {
	public UncertaintyVariationModelGenPcm(String baseUri) {
		this.variationManager = new VariationManager(
				baseUri, 
				Arrays.asList("allocation", "repository", "resourceenvironment", "system", "usagemodel")
		);
	}
	
	//?
	private void patchAllocationContext(Allocation alloc, final AllocationContext allocCon, final ResourceContainer resCon) {
		for (AllocationContext it: alloc.getAllocationContexts_Allocation()) {
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
		final UncertaintyVariations variantions = (UncertaintyVariations) variationManager.loadUncertaintyVariantModel("port");
		
		//Iterator
		int variationPoint = 0;
		VaryingAllocationContext varAlloc = (VaryingAllocationContext)variantions.getVariationPoints().get(variationPoint);
		progressMonitor.beginTask("creating variations", varAlloc.getTargetResourceVariations().size());
		for (int i = 0; i < varAlloc.getTargetResourceVariations().size(); ++i) {
            try {
				variationManager.createCurrVariant(i, progressMonitor);
				Map<String, List<EObject>> models = variationManager.loadCurrVariantModels();
				
				for (EObject it : models.get("allocation")) {
					Allocation alloc = (Allocation)it;
					ResourceContainer resCon = resolve(alloc.getTargetResourceEnvironment_Allocation(), varAlloc.getTargetResourceVariations().get(i));
					patchAllocationContext(alloc, varAlloc.getAllocationContext(), resCon);
					
				}
				
				variationManager.storeCurrVariantModels(models);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		progressMonitor.done();
	}
	
	private VariationManager variationManager;
}
