package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * ResourceAbstraction allows decoupling
 *
 */
public interface ResourceAbstraction {

    EObject load(URI modelUri);

    /**
     * @param rootElement
     * @throws IOException
     */
    void save(EObject rootElement) throws IOException;

    void updateRegisteredModels(final List<String> knownModelTypes);
}