package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 *
 */
public interface ResourceAbstraction {

    /**
     * loads and returns the model corresponding to the modelUri
     *
     * @param modelUri
     *            the uri of the model
     * @return the loaded model
     */
    EObject load(URI modelUri);

    /**
     * saved the model
     *
     * @param rootElement
     *            the model to save
     * @throws IOException
     *             if the writing of the model fails
     */
    void save(EObject rootElement) throws IOException;

    /**
     * updates the registered models with a list of new models
     *
     * @param knownModelTypes
     *            the new model that should be registered
     */
    void updateRegisteredModels(final List<String> knownModelTypes);
}