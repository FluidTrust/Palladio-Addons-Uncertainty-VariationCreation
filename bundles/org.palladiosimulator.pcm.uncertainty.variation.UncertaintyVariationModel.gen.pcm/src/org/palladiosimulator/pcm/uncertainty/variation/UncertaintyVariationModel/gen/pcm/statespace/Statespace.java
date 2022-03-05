package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.StateHandler;
import UncertaintyVariationModel.statehandler.StateHandlerFactory;

/**
 * Statespace represents the state space spanned by the variation points of the uncertainty
 * variation model
 */
public class Statespace {
    /**
     * Constructor
     *
     * @param uncertaintyVariationModel
     *            the uncertainty variation model for this Statespace
     * @throws IllegalStateException
     *             if no StateHandlerImplementation can be created for any of the Variation Points
     */
    public Statespace(final EObject uncertaintyVariationModel) {
        this.uncertaintyVariations = (UncertaintyVariations) uncertaintyVariationModel;
        final StateHandlerFactory factory = StateHandlerFactory.INSTANCE;

        this.stateHandlers = this.uncertaintyVariations.getVariationPoints()
            .stream()
            .map(it -> factory.createFor(it))
            .collect(Collectors.toList());
    }

    /**
     * returns the names of the model types used by the statehandlers of the various variant points
     *
     * @return list of names of model types which are used by one of the statehandlers
     */
    public List<String> getModelTypes() {
        return this.stateHandlers.stream()
            .flatMap(hnd -> hnd.getModelTypes()
                .stream())
            .distinct()
            .collect(Collectors.toList());
    }

    /**
     * creates and returns an iterator for traversing this Statespace
     *
     * @return iterator for this Statespace
     */
    public StatespaceIterator iterator() {
        return new ConcreteStatespaceItertator(this);
    }

    /**
     * patches the models affected by the dimension with the current variation.
     *
     * @param models
     *            the models which are used by one of the statehandlers
     * @param dimension
     *            the specific dimension
     * @param variationIdx
     *            the current position in the dimension
     */
    public void patchModelsWith(final Map<String, List<EObject>> models, final int dimension, final int variationIdx) {
        this.stateHandlers.get(dimension)
            .patchModelWith(models, this.translateDimentionToVariationPoint(dimension), variationIdx);
    }

    /**
     * return the value of the dimension corresponding to the variationIdx
     * 
     * @param dimension
     *            the specific dimension
     * @param variationIdx
     *            the current position in the dimension
     * @return the value as string containing either the name with id of the value, the id of value
     *         or the variationIdx based on the variation point description
     */
    public String getValue(final int dimension, final int variationIdx) {
        return this.stateHandlers.get(dimension)
            .getValue(this.translateDimentionToVariationPoint(dimension), variationIdx);
    }

    /**
     * returns the dimension (cardinality) of the Statespace
     *
     * @return the number of different Variation Points
     */
    public int getNumberOfDimensions() {
        return this.uncertaintyVariations.getVariationPoints()
            .size();
    }

    /**
     * returns dimension as a named list
     *
     * @return list containing the names of the different variation points.
     */
    public List<String> getDimensions() {
        final var res = this.uncertaintyVariations.getVariationPoints()
            .stream()
            .map(it -> it.getEntityName())
            .collect(Collectors.toList());
        return res;
    }

    /**
     * return the size of a specific dimension
     *
     * @param dimension
     *            the specific dimension
     * @return the number of variations in a specific dimension
     * @throws IllegalArgumentException
     *             if the specific dimension is not inside of the dimensions of the statespace
     */
    public int getSizeOfDimension(final int dimension) {
        if (!(dimension < this.getNumberOfDimensions())) {
            throw new IllegalArgumentException("dimension " + dimension + " does not exists.");
        }

        return this.stateHandlers.get(dimension)
            .getSizeOfDimension(this.translateDimentionToVariationPoint(dimension));
    }

    private VariationPoint translateDimentionToVariationPoint(final int dimension) {
        return this.uncertaintyVariations.getVariationPoints()
            .get(dimension);
    }

    private final UncertaintyVariations uncertaintyVariations;
    private final List<StateHandler> stateHandlers;

}
