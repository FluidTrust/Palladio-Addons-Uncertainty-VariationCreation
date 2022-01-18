package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;

public class VariationManager {
    public VariationManager(final String baseUri) {
        this.modelBaseUri = baseUri + "/models";
        this.resourceAbstraction = new ModelResourceAbstraction(Arrays.asList(UNCERTAINTY_VARAINT_MODEL_TYPE));
    }

    public EObject loadUncertaintyVariantModel(final String name) {
        final String modelUri = this.modelBaseUri + "/" + name + "." + UNCERTAINTY_VARAINT_MODEL_TYPE;
        return this.resourceAbstraction.load(modelUri);
    }

    private final String modelBaseUri;
    private final ResourceAbstraction resourceAbstraction;
    private static final String UNCERTAINTY_VARAINT_MODEL_TYPE = "uncertaintyvariationmodel";

}
