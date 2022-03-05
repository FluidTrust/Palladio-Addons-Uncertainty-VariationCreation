package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.confidentiality.pcm.model.confidentiality.characteristics.EnumCharacteristic;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

import UncertaintyVariationModel.ValueCollection;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.GenericStateHandler;

/**
 * CharacteristicsStateHandler handles the state of variation points that vary Confidentiality
 * Characteristics annotations of the palladio component model
 */
public class CharacteristicsStateHandler extends GenericStateHandler {

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
        final ValueCollection vals = (ValueCollection) desc.getTargetVariations()
            .get(variationIdx);
        final List<Optional<EObject>> resolvedVariations = this.resolve(models.get(MODEL_TYPE2), vals.getLinks());

        for (final EObject container : models.get(MODEL_TYPE1)) {
            final Optional<EObject> resolvedSubject = this.resolve(container, variationPoint.getVaryingSubjects()
                .get(0));
            resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariations));
        }

    }

    @Override
    public List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2);
    }

    @Override
    public String getValue(final VariationPoint variationPoint, final int variationIdx) {
        final var desc = variationPoint.getVariationDescription();
        final var vals = (ValueCollection) desc.getTargetVariations()
            .get(variationIdx);
        final var links = vals.getLinks();
        final var names = links.stream()
            .map(it -> (Literal) it)
            .map(it -> {
                if (it.getName() == null) {
                    return it.getId();
                }
                return it.getName()
                    .trim() + " " + it.getId();
            })
            .collect(Collectors.toList());
        final var joinedNames = String.join(",", names);
        return joinedNames;
    }

    private void patch(final EObject element, final List<Optional<EObject>> values) {
        final EnumCharacteristic resolved = (EnumCharacteristic) element;
        resolved.getValues()
            .clear();
        values.forEach(value -> value.ifPresent(val -> {
            resolved.getValues()
                .add((Literal) val);
        }));
    }

    private static final String MODEL_TYPE1 = "characteristics";
    private static final String MODEL_TYPE2 = "pddc";

}
