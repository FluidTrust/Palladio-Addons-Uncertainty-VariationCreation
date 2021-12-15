package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.VaryingAllocationContext;

public class AllocationStateHandler implements StateHandler {

	@Override
	public int getSizeOfDimension(VariationPoint variationPoint) {
		return ((VaryingAllocationContext)variationPoint).getTargetResourceVariations().size();
	}

	@Override
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx) {
		VaryingAllocationContext varyingAllocationContext = (VaryingAllocationContext)variationPoint;
		for (EObject it : models.get(MODEL_TYPE)) {
			Allocation allocation = (Allocation)it;
			ResourceContainer resourceContainer = this.resolve(allocation.getTargetResourceEnvironment_Allocation(), varyingAllocationContext.getTargetResourceVariations().get(variationIdx));
			patch(allocation, varyingAllocationContext.getAllocationContext(), resourceContainer);
		}
		
	}
	
	public static List<String> GET_MODEL_TYPES() { return Arrays.asList(MODEL_TYPE); }
	
	private static final String MODEL_TYPE = "allocation";

	private ResourceContainer resolve(ResourceEnvironment resourceEnvironment, ResourceContainer element) {
		ResourceContainer resolved = null;
		for (ResourceContainer it: resourceEnvironment.getResourceContainer_ResourceEnvironment()) {
			if (it.getId().equalsIgnoreCase(element.getId())) {
				resolved = it;
				break;
			}
		}
		
		return resolved;
	}
	
	private void patch(Allocation allocation, final AllocationContext element, final ResourceContainer value) {
		for (AllocationContext it: allocation.getAllocationContexts_Allocation()) {
			if (it.getId().equalsIgnoreCase(element.getId())) {
				it.setResourceContainer_AllocationContext(value);
			}
		}
	}
}
