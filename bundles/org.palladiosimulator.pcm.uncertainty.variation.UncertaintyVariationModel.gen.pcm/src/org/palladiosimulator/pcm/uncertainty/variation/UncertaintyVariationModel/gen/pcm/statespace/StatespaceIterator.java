package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * StatespaceIterator represents a traversal iteration for the Statespace
 */
public interface StatespaceIterator {
    /**
     * tests and returns whether the Statespace has not yet been completely traversaled
     *
     * @return true if it has not yet been completely traversaled otherwise false
     */
    public boolean hasNext();

    /**
     * traversals the statespace by one step. In the case the statespace has been completely
     * traversaled this function will do nothing and will immediately return.
     */
    public void next();

    /**
     * patches the models with the current variation
     *
     * @param models
     *            the models
     */
    public void patchModels(Map<String, List<EObject>> models);

    /**
     * return the current state of the StatespaceIterator
     *
     * @return list containing the state for each dimension
     */
    public List<String> getCurrentState();
}
