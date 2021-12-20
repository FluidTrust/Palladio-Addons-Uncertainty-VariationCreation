package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

public class AllocationStateHandler extends GenericStateHandler {

	@Override
	public int getSizeOfDimension(VariationPoint variationPoint) {
		VariationDescription desc = variationPoint.getVariationDescription();
		return desc.getTargetVariations().size();
	}

	@Override
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx) {
		VariationDescription desc = variationPoint.getVariationDescription();
		for (EObject container : models.get(MODEL_TYPE)) {
			Allocation allocation = (Allocation)container;
			Optional<EObject> resolvedVariation = resolve(allocation.getTargetResourceEnvironment_Allocation(), desc.getTargetVariations().get(variationIdx));
			Optional<EObject> resolvedSubject = resolve(allocation, variationPoint.getVaryingSubjects().get(0));
			resolvedSubject.ifPresent(subject -> patch(subject, resolvedVariation));
		}
		
	}
	
	public static List<String> GET_MODEL_TYPES() { return Arrays.asList(MODEL_TYPE); }	
	
	private void patch(EObject element, Optional<EObject> value) {
		value.ifPresent(val -> {
			AllocationContext resolved = (AllocationContext)element;
			resolved.setResourceContainer_AllocationContext((ResourceContainer)val);
		});
	}
	
	private static final String MODEL_TYPE = "allocation";
}
