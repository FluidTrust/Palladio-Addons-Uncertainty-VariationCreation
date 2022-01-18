package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;

import UncertaintyVariationModel.VariationPoint;
import de.uka.ipd.sdq.identifier.Identifier;

public class BranchStateHandler extends GenericStateHandler {
    @Override
    public int getSizeOfDimension(final VariationPoint variationPoint) {
        int resultingDim = 0;
        final Identifier firstSubject = variationPoint.getVaryingSubjects()
            .get(0);
        if (firstSubject instanceof BranchAction) {
            resultingDim = ((BranchAction) firstSubject).getBranches_Branch()
                .size();
        }
        if (firstSubject instanceof Branch) {
            resultingDim = ((Branch) firstSubject).getBranchTransitions_Branch()
                .size();
        }
        return resultingDim;
    }

    @Override
    public void patchModelWith(final Map<String, List<EObject>> models, final VariationPoint variationPoint,
            final int variationIdx) {
        for (final EObject container : models.get(MODEL_TYPE1)) {
            for (final Identifier curr : variationPoint.getVaryingSubjects()) {
                if (curr instanceof BranchAction) {
                    final BranchAction a = (BranchAction) curr;
                    final Optional<EObject> resolvedVariation = this.resolve(container, a.getBranches_Branch()
                        .get(variationIdx));
                    final Optional<EObject> resolvedSubject = this.resolve(container, curr);
                    resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariation));
                }
            }
        }

        for (final EObject container : models.get(MODEL_TYPE2)) {
            for (final Identifier curr : variationPoint.getVaryingSubjects()) {
                if (curr instanceof Branch) {
                    final Optional<EObject> resolvedSubject = this.resolve(container, curr);
                    resolvedSubject.ifPresent(subject -> this.patch(subject, variationIdx));
                }
            }
        }
    }

    public static List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2);
    }

    private static final String MODEL_TYPE1 = "repository";
    private static final String MODEL_TYPE2 = "usagemodel";

    private void patch(final EObject subject, final Optional<EObject> value) {
        value.ifPresent(val -> {
            if (val instanceof GuardedBranchTransition) {
                ((GuardedBranchTransition) val).getBranchCondition_GuardedBranchTransition()
                    .setSpecification("true");
            }
            if (val instanceof ProbabilisticBranchTransition) {
                ((ProbabilisticBranchTransition) val).setBranchProbability(1.0);
            }

            final BranchAction resolved = (BranchAction) subject;
            resolved.getBranches_Branch()
                .clear();
            resolved.getBranches_Branch()
                .add((AbstractBranchTransition) val);
        });
    }

    private void patch(final EObject subject, final int index) {
        final Branch resolved = (Branch) subject;
        final BranchTransition value = resolved.getBranchTransitions_Branch()
            .get(index);
        value.setBranchProbability(1.0);
        resolved.getBranchTransitions_Branch()
            .clear();
        resolved.getBranchTransitions_Branch()
            .add(value);
    }

}
