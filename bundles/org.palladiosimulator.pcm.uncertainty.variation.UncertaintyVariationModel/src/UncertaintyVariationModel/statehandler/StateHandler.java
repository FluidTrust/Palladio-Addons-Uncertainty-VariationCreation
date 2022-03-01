package UncertaintyVariationModel.statehandler;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.VariationPoint;

/**
 * StateHandler describes an implementation of the StateHandler for sizing and patching the
 * variation space of a VariationPoint.
 */
public interface StateHandler {
    /**
     * computes and return the size of a VariationPoints variation space.
     * 
     * @param variationPoint
     *            the current VariationPoint
     * @return the computed size of the variation space
     */
    public int getSizeOfDimension(VariationPoint variationPoint);

    /**
     * returns a list of models which the StateHandler uses.
     * 
     * @return list of the names of the used models. It is never empty.
     */
    public List<String> getModelTypes();

    /**
     * patches the models with a VariationPoints variationIdx variation.
     * 
     * @param models
     *            the models which are uses by one of the StateHandlers
     * @param variationPoint
     *            the current VariationPoint
     * @param variationIdx
     *            the current position in the VariationPoints variation space
     */
    public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx);
}
