package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

public class AssemblyStateHandler extends GenericStateHandler {

	@Override
	public int getSizeOfDimension(VariationPoint variationPoint) {
		VariationDescription desc = variationPoint.getVariationDescription();
		return desc.getTargetVariations().size();
	}

	@Override
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx) {
		VariationDescription desc = variationPoint.getVariationDescription();
		for (String modelType : GET_MODEL_TYPES()) {
			for (EObject container : models.get(modelType)) {
				for (Entity curr : variationPoint.getVaryingSubjects()) {
					Optional<EObject> resolvedVariation = resolve(models.get(MODEL_TYPE2), desc.getTargetVariations().get(variationIdx));
					Optional<EObject> resolvedSubject = resolve(container, curr);
					resolvedSubject.ifPresent(subject -> patch(subject, resolvedVariation));
				}
			}
		}		
	}
	
	public static List<String> GET_MODEL_TYPES() { return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2); }
	
	private static final String MODEL_TYPE1 = "system";
	private static final String MODEL_TYPE2 = "repository";
	
	private void patch(EObject subject, Optional<EObject> value) {
		value.ifPresent(val -> {
			AssemblyContext resolved = (AssemblyContext)subject;
			resolved.setEncapsulatedComponent__AssemblyContext((RepositoryComponent)val);
		});
	}
}
