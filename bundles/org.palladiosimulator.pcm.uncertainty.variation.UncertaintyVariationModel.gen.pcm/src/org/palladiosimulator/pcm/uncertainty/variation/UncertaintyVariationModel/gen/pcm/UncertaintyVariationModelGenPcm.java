package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UncertaintyVariationModelGenPcm realizes the generation of the uncertainty varied palladio
 * component model (pcm) based the specified uncertainty variation model.
 */
public class UncertaintyVariationModelGenPcm {
    /**
     * Constructor
     *
     * @param uncertaintyModelUri
     *            specifies the uniform resource identifier (uri) which points to the uncertainty
     *            variation model to use. The uri must be of the platform type.
     * @throws CoreException
     *             if result directory can not be created in the case it does not exist
     * @throws IllegalArgumentException
     *             if the given URI of the uncertainty variation model is valid
     */
    public UncertaintyVariationModelGenPcm(final URI uncertaintyModelUri) throws CoreException {
        this(uncertaintyModelUri, "source", "scenarios", "configuration");
    }

    /**
     * Constructor
     *
     * @param uncertaintyModelUri
     *            specifies the uniform resource identifier (uri) which points to the uncertainty
     *            variation model to use. The uri must be of the platform type.
     * @param sourceDirName
     *            name of the directory in which the model templates for the variants will be
     *            searched in.
     * @param resultDirName
     *            name of the directory in which the all variants will be saved in
     * @param variantDirName
     *            name of the directory in which one variant will be saved in
     * @throws CoreException
     *             if result directory can not be created in the case it does not exist
     * @throws IllegalArgumentException
     *             if the given URI of the uncertainty variation model is valid
     */
    public UncertaintyVariationModelGenPcm(final URI uncertaintyModelUri, final String sourceDirName,
            final String resultDirName, final String variantDirName) throws CoreException {
        final Logger logger = LoggerFactory.getLogger("org.palladiosimulator.pcm.uncertainty.variation.logger");
        VariationManager.validate(uncertaintyModelUri, logger);
        // final ResourceAbstraction resourceAbstraction = new ModelResourceAbstraction(null);
        final var variationManager = new VariationManager(uncertaintyModelUri);
        final var scenarioManager = new ConcreteScenarioManager(uncertaintyModelUri.trimSegments(1), sourceDirName,
                resultDirName, variantDirName);

        this.impl = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
    }

    /**
     * generates the different scenarios, which will found under scenario directory of the current
     * project, from the pcm based on the uncertainty variation model.
     *
     * @param progressMonitor
     *            progress monitor for status reporting
     */
    public void generateVariations(final IProgressMonitor progressMonitor) {
        this.impl.generateVariations(progressMonitor);
    }

    private final UncertaintyVariationModelGenPcmImpl impl;
}
