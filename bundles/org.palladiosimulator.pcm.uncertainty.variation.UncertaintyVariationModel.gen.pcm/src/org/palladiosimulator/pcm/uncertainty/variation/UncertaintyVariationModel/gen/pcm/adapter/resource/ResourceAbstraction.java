package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

public interface ResourceAbstraction {
    void register(String modelType);

    EObject load(String modelUri);

    void save(EObject rootElement) throws IOException;

}