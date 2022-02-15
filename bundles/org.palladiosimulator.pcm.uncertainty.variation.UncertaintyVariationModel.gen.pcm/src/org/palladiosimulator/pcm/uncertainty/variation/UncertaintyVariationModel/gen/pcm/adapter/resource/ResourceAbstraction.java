package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 *
 */
public interface ResourceAbstraction {
    /**
     * 
     */
    EObject load(URI modelUri);

    /**
     * 
     * @param rootElement
     * @throws IOException
     */
    void save(EObject rootElement) throws IOException;

}