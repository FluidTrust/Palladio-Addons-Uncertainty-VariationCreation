package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.GenericStateHandler;

/**
 * AllocationStateHandler handles the state of variation points that vary the AllocationContext's
 * RessourceContainer assignment of the palladio component model
 */
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
        final PrimitiveValue val = (PrimitiveValue) desc.getTargetVariations()
            .get(variationIdx);
        final Optional<EObject> resolvedVariation = this.resolve(models.get(MODEL_TYPE2), val.getLink());

        for (final EObject container : models.get(MODEL_TYPE1)) {
            final Optional<EObject> resolvedSubject = this.resolve(container, variationPoint.getVaryingSubjects()
                .get(0));
            resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariation));
        }

    }

    @Override
    public List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2);
    }

    @Override
    public String getValue(final VariationPoint variationPoint, final int variationIdx) {
        final var desc = variationPoint.getVariationDescription();
        final var val = (PrimitiveValue) desc.getTargetVariations()
            .get(variationIdx);
        final var linked = (ResourceContainer) val.getLink();
        return linked.getEntityName()
            .trim() + " " + linked.getId();
    }

    private void patch(final EObject element, final Optional<EObject> value) {
        value.ifPresent(val -> {
            final AllocationContext resolved = (AllocationContext) element;
            resolved.setResourceContainer_AllocationContext((ResourceContainer) val);
        });
    }

    private static final String MODEL_TYPE1 = "allocation";
    private static final String MODEL_TYPE2 = "resourceenvironment";
}
