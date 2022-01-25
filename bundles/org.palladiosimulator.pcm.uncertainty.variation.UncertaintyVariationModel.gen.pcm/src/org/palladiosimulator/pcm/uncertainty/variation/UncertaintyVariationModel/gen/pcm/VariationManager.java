package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;

/**
 * The class VariationManager realizes the management of the uncertainty variation model.
 */
public class VariationManager {
    /**
     * Constructor
     * 
     * @param baseUri
     *            specifies the uniform resource identifier (uri) which points to the base project
     *            for the varying. The uri must be of the platform type. The uncertainty variation
     *            model will be searched in the models subdirectory of the uri.
     */
    public VariationManager(final String baseUri) {
        this.modelBaseUri = baseUri + "/models";
        this.resourceAbstraction = new ModelResourceAbstraction(Arrays.asList(UNCERTAINTY_VARAINT_MODEL_TYPE));
    }

    /**
     * The function loadUncertaintyVariationModel loads and returns the specified uncertainty
     * variant model of the current project.
     * 
     * @param name
     *            specifies the name of the uncertainty variation model.
     * 
     * @return the loaded uncertainty variation model.
     */
    public EObject loadUncertaintyVariantModel(final String name) {
        final String modelUri = this.modelBaseUri + "/" + name + "." + UNCERTAINTY_VARAINT_MODEL_TYPE;
        return this.resourceAbstraction.load(modelUri);
    }

    private final String modelBaseUri;
    private final ResourceAbstraction resourceAbstraction;
    private static final String UNCERTAINTY_VARAINT_MODEL_TYPE = "uncertaintyvariationmodel";

}
