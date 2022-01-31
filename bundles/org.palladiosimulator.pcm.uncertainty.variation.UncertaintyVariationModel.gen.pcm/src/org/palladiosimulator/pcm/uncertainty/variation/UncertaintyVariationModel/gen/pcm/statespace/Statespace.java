package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.statehandler.StateHandler;
import UncertaintyVariationModel.statehandler.StateHandlerFactory;

public class Statespace {
    public Statespace(final EObject uncertaintyVariations) {
        this.uncertaintyVariations = (UncertaintyVariations) uncertaintyVariations;
        this.stateHandlers = new ArrayList<>();
        final StateHandlerFactory factory = StateHandlerFactory.INSTANCE;

        this.uncertaintyVariations.getVariationPoints()
            .stream()
            .forEach(it -> this.stateHandlers.add(factory.createFor(it)));
    }

    public List<String> getModelTypes() {
        return stateHandlers.stream()
            .flatMap(hnd -> hnd.getModelTypes()
                .stream())
            .distinct()
            .collect(Collectors.toList());
    }

    public StatespaceIterator iterator() {
        return new ConcreteStatespaceItertator(this);
    }

    public void patchModelsWith(final Map<String, List<EObject>> models, final int dimension, final int variationIdx) {
        this.stateHandlers.get(dimension)
            .patchModelWith(models, this.uncertaintyVariations.getVariationPoints()
                .get(dimension), variationIdx);
    }

    public int getNumberOfDimensions() {
        return this.uncertaintyVariations.getVariationPoints()
            .size();
    }

    public int getSizeOfDimension(final int dimension) {
        return this.stateHandlers.get(dimension)
            .getSizeOfDimension(this.uncertaintyVariations.getVariationPoints()
                .get(dimension));
    }

    private final UncertaintyVariations uncertaintyVariations;
    private final List<StateHandler> stateHandlers;

}
