package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.VaryingBranch;
import de.uka.ipd.sdq.identifier.Identifier;

public class BranchStateHandler implements StateHandler {
	@Override
	public int getSizeOfDimension(VariationPoint variationPoint) {
		int resultingDim = 0;
		VaryingBranch varyingBranch = (VaryingBranch)variationPoint;
		if (!varyingBranch.getBranchActions().isEmpty())
			resultingDim += varyingBranch.getBranchActions().get(0).getBranches_Branch().size();
		if (!varyingBranch.getBranches().isEmpty())
			resultingDim += varyingBranch.getBranches().get(0).getBranchTransitions_Branch().size();
		return resultingDim;
	}

	@Override
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx) {
		VaryingBranch varyingBranch = (VaryingBranch)variationPoint;
		for (EObject it : models.get(MODEL_TYPE1)) {
			Repository repository = (Repository)it;
			for (Iterator<BranchAction> it2 = varyingBranch.getBranchActions().iterator(); it2.hasNext(); ) {
			   BranchAction curr = it2.next();
			   AbstractBranchTransition abstactBranchTransition = resolve(repository, curr.getBranches_Branch().get(variationIdx));
			   patch(repository, curr, abstactBranchTransition);
			}
		}
		
		for (EObject it : models.get(MODEL_TYPE2)) {
			UsageModel usagemodel = (UsageModel)it;
			for (Iterator<Branch> it2 = varyingBranch.getBranches().iterator(); it2.hasNext(); ) {
				Branch curr = it2.next();
				patch(usagemodel, curr, variationIdx);
			}
			
		}
		
	}
	
	public static List<String> GET_MODEL_TYPES() { return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2); }
	
	private static final String MODEL_TYPE1 = "repository";
	private static final String MODEL_TYPE2 = "usagemodel";
	
	private AbstractBranchTransition resolve(Repository repository, AbstractBranchTransition element) {
		AbstractBranchTransition resolved = null;
		for (TreeIterator<EObject> it = repository.eAllContents(); it.hasNext();) {
			EObject curr = it.next();
			if (!(curr instanceof Identifier))
				continue;
			if (((Identifier)curr).getId().equalsIgnoreCase(element.getId())) {
				resolved = (AbstractBranchTransition)curr;
				break;
			}
		}
		
		return resolved;
	}

	private void patch(Repository repository, BranchAction element, AbstractBranchTransition value) {
		if (value instanceof GuardedBranchTransition) {
			((GuardedBranchTransition)value).getBranchCondition_GuardedBranchTransition().setSpecification("true");
		}
		if (value instanceof ProbabilisticBranchTransition) {
			((ProbabilisticBranchTransition)value).setBranchProbability(1.0);
		}
		
		for (TreeIterator<EObject> it = repository.eAllContents(); it.hasNext();) {
			EObject curr = it.next();
			if (!(curr instanceof Identifier))
				continue;			
			if (((Identifier)curr).getId().equalsIgnoreCase(element.getId())) {
				BranchAction resolved = (BranchAction)curr;
				resolved.getBranches_Branch().clear();
				resolved.getBranches_Branch().add(value);
			}
		}
	}
	
	private void patch(UsageModel usageModel, Branch element, int index) {
		for (TreeIterator<EObject> it = usageModel.eAllContents(); it.hasNext();) {
			EObject curr = it.next();
			if (!(curr instanceof Identifier))
				continue;			
			if (((Identifier)curr).getId().equalsIgnoreCase(element.getId())) {
				Branch resolved = (Branch)curr;
				BranchTransition value = resolved.getBranchTransitions_Branch().get(index);
				value.setBranchProbability(1.0);
				resolved.getBranchTransitions_Branch().clear();
				resolved.getBranchTransitions_Branch().add(value);
			}
		}
	}	

}
