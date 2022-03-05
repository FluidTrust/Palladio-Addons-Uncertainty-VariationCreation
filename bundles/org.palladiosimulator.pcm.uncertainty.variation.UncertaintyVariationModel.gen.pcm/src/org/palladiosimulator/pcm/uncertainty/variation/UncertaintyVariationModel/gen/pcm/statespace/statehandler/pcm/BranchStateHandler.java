package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.usagemodel.Branch;
import org.palladiosimulator.pcm.usagemodel.BranchTransition;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.GenericStateHandler;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * BranchStateHandler handles the state of variation points that vary the Transitions of the
 * BranchActions (SEFF) or Branches (Usage Model) of the palladio component model
 */
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
                    final BranchAction currBranchAction = (BranchAction) curr;
                    final Optional<EObject> resolvedVariation = this.resolve(container,
                            currBranchAction.getBranches_Branch()
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

    @Override
    public List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2);
    }

    @Override
    public String getValue(final VariationPoint variationPoint, final int variationIdx) {
        final var subjects = variationPoint.getVaryingSubjects();
        final var branchActionNames = subjects.stream()
            .filter(it -> it instanceof BranchAction)
            .map(it -> {
                final var branch = ((BranchAction) it).getBranches_Branch()
                    .get(variationIdx);
                return branch.getEntityName()
                    .trim() + " " + branch.getId();
            })
            .collect(Collectors.toList());

        final var branchNames = subjects.stream()
            .filter(it -> it instanceof Branch)
            .map(it -> String.valueOf(variationIdx))
            .collect(Collectors.toList());
        branchActionNames.addAll(branchNames);

        final var joinedNames = String.join(",", branchActionNames);
        return joinedNames;
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
