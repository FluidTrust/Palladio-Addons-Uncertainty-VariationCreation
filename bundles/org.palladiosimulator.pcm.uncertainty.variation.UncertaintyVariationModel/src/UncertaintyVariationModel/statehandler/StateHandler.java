package UncertaintyVariationModel.statehandler;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.VariationPoint;

/*
 * 
 */
public interface StateHandler {
    /*
     * 
     */
    public int getSizeOfDimension(VariationPoint variationPoint);

    /*
     * 
     */
    public List<String> getModelTypes();

    /*
     * 
     */
    public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx);
}
