package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

public class AllocationStateHandler extends GenericStateHandler {

    @Override
    public int getSizeOfDimension(final VariationPoint variationPoint) {
        final VariationDescription desc = variationPoint.getVariationDescription();
        return desc.getTargetVariations()
            .size();
    }

    @Override
    public void patchModelWith(final Map<String, List<EObject>> models, final VariationPoint variationPoint,
            final int variationIdx) {
        final VariationDescription desc = variationPoint.getVariationDescription();
        for (final EObject container : models.get(MODEL_TYPE)) {
            final Allocation allocation = (Allocation) container;
            final PrimitiveValue val = (PrimitiveValue) desc.getTargetVariations()
                .get(variationIdx);
            final Optional<EObject> resolvedVariation = this
                .resolve(allocation.getTargetResourceEnvironment_Allocation(), val.getLink());
            final Optional<EObject> resolvedSubject = this.resolve(allocation, variationPoint.getVaryingSubjects()
                .get(0));
            resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariation));
        }

    }

    @Override
    public List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE);
    }

    private void patch(final EObject element, final Optional<EObject> value) {
        value.ifPresent(val -> {
            final AllocationContext resolved = (AllocationContext) element;
            resolved.setResourceContainer_AllocationContext((ResourceContainer) val);
        });
    }

    private static final String MODEL_TYPE = "allocation";
}
