package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;
import org.slf4j.Logger;

/**
 * VariationManager realizes the management of the uncertainty variation model.
 */
public class VariationManager {
    /**
     * Constructor
     *
     * @param uncertaintyVariationModel
     *            specifies the uniform resource identifier (uri) which points to the uncertainty
     *            variation model for the varying. The uri must be of the platform type.
     */
    public VariationManager(final URI uncertaintyVariationModel) {
        this.uncertaintyVaritionModel = uncertaintyVariationModel;
        this.resourceAbstraction = new ModelResourceAbstraction(Arrays.asList(UNCERTAINTY_VARAINT_MODEL_TYPE));
    }

    /**
     * loads and returns the specified uncertainty variant model of the current project.
     *
     * @return the loaded uncertainty variation model.
     */
    public EObject loadUncertaintyVariantModel() {
        return this.resourceAbstraction.load(this.uncertaintyVaritionModel);
    }

    /**
     * validates a given uncertainty variation model
     * 
     * @param uncertaintyVariationModel
     *            specifies the uniform resource identifier (uri) which points to the uncertainty
     *            variation model for the varying.
     * @throws IllegalArgumentException
     *             if the given URI of the uncertainty variation model is valid
     */
    public static void validate(final URI uncertaintyVariationModel, Logger logger) {
        if (uncertaintyVariationModel == null) {
            logger.error("uncertainty model uri must not be null");
            throw new IllegalArgumentException("uncertainty model uri must not be null");
        }

        if (!uncertaintyVariationModel.isPlatform()) {
            logger.error("uncertainty model uri must be of the platform type but is "
                    + uncertaintyVariationModel.toString());
            throw new IllegalArgumentException("uncertainty model uri must be of the platform type");
        }

        if (!uncertaintyVariationModel.fileExtension()
            .equalsIgnoreCase(UNCERTAINTY_VARAINT_MODEL_TYPE)) {
            logger.error("uncertainty model uri must point to a uncertainty variation model but points to "
                    + uncertaintyVariationModel.lastSegment());
            throw new IllegalArgumentException("uncertainty model uri must be of the platform type");
        }
    }

    private final URI uncertaintyVaritionModel;
    private final ResourceAbstraction resourceAbstraction;
    private static final String UNCERTAINTY_VARAINT_MODEL_TYPE = "uncertaintyvariationmodel";

}
