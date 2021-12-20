package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import UncertaintyVariationModel.VariationPoint;

public class BranchStateHandler extends GenericStateHandler {
	@Override
	public int getSizeOfDimension(VariationPoint variationPoint) {
		int resultingDim = 0;
		Entity entity = variationPoint.getVaryingSubjects().get(0);
		if (entity instanceof BranchAction) {
			resultingDim = ((BranchAction)entity).getBranches_Branch().size();
		}
		if (entity instanceof Branch) {
			resultingDim = ((Branch)entity).getBranchTransitions_Branch().size();
		}
		return resultingDim;
	}

	@Override
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx) {
		Entity entity = variationPoint.getVaryingSubjects().get(0);
		if (entity instanceof BranchAction) {
			for (EObject container : models.get(MODEL_TYPE1)) {
				for (Entity curr : variationPoint.getVaryingSubjects()) {
					BranchAction a = (BranchAction)curr;
					Optional<EObject> resolvedVariation = resolve(container, a.getBranches_Branch().get(variationIdx));
					Optional<EObject> resolvedSubject = resolve(container, curr);
					resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariation));
				}
			}
		} else {
			for (EObject container : models.get(MODEL_TYPE2)) {
				for (Entity curr : variationPoint.getVaryingSubjects()) {
					Optional<EObject> resolvedSubject = resolve(container, curr);
					resolvedSubject.ifPresent(subject -> this.patch(subject, variationIdx));
				}
				
			}
		}
	}
	
	public static List<String> GET_MODEL_TYPES() { return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2); }
	
	private static final String MODEL_TYPE1 = "repository";
	private static final String MODEL_TYPE2 = "usagemodel";
	
	private void patch(EObject subject, Optional<EObject> value) {
		value.ifPresent(val -> {
			if (val instanceof GuardedBranchTransition) {
				((GuardedBranchTransition)val).getBranchCondition_GuardedBranchTransition().setSpecification("true");
			}
			if (val instanceof ProbabilisticBranchTransition) {
				((ProbabilisticBranchTransition)val).setBranchProbability(1.0);
			}
			
			BranchAction resolved = (BranchAction)subject;
			resolved.getBranches_Branch().clear();
			resolved.getBranches_Branch().add((AbstractBranchTransition)val);
		});
	}
	
	private void patch(EObject subject, int index) {
		Branch resolved = (Branch)subject;
		BranchTransition value = resolved.getBranchTransitions_Branch().get(index);
		value.setBranchProbability(1.0);
		resolved.getBranchTransitions_Branch().clear();
		resolved.getBranchTransitions_Branch().add(value);
	}	

}
