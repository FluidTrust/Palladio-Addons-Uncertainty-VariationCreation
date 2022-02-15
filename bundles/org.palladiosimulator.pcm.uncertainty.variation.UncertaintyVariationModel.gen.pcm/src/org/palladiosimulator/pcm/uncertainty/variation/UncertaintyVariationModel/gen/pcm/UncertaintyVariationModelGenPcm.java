package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.net4j.util.om.monitor.SubMonitor;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;
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
     */
    public UncertaintyVariationModelGenPcm(final URI uncertaintyModelUri) throws CoreException {
        if (uncertaintyModelUri == null || !uncertaintyModelUri.isPlatform()) {
            LOGGER.error("uncertainty model uri must be of the platform type but is " + uncertaintyModelUri.toString());
            throw new IllegalArgumentException("uncertainty model uri must be of the platform type");
        }
        this.scenarioManager = new ScenarioManager(uncertaintyModelUri.trimSegments(1));
        this.variationManager = new VariationManager(uncertaintyModelUri);
    }

    /**
     * generateVariations generates the different scenarios, which will found under scenario
     * directory of the current project, from the pcm based on the uncertainty variation model.
     *
     * @param progressMonitor
     */
    public void generateVariations(final IProgressMonitor progressMonitor) {
        try {
            final SubMonitor progressSubMonitor = SubMonitor.convert(progressMonitor);
            final Statespace statespace = new Statespace(this.variationManager.loadUncertaintyVariantModel());
            this.scenarioManager.register(statespace.getModelTypes());

            int i = 0;
            for (final StatespaceIterator it = statespace.iterator(); it.hasNext(); it.next()) {
                final SubMonitor iterationMonitor = progressSubMonitor.setWorkRemaining(100)
                    .newChild(1);
                iterationMonitor.subTask("generating scenario " + i);
                this.scenarioManager.createCurrVariant(i, iterationMonitor);
                final Map<String, List<EObject>> models = this.scenarioManager.loadCurrVariantModels();
                it.patchModels(models);
                this.scenarioManager.storeCurrVariantModels(models);
                ++i;
            }
        } catch (final CoreException e) {
            LOGGER.error("Ressource not found", e);
        } catch (final IOException e) {
            LOGGER.error("cannot write model", e);
        } catch (final IllegalStateException e) {
            LOGGER.error("uncertainty model misformed", e);
        }
    }

    private final ScenarioManager scenarioManager;
    private final VariationManager variationManager;
    private static final Logger LOGGER = LoggerFactory
        .getLogger("org.palladiosimulator.pcm.uncertainty.variation.logger");
}
