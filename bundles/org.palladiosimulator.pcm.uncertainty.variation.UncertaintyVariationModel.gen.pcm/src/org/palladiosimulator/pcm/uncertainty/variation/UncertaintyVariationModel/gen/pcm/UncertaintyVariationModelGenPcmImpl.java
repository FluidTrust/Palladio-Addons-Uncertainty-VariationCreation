package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.net4j.util.om.monitor.SubMonitor;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;
import org.slf4j.Logger;

/**
 * UncertaintyVariationModelGenPcmImpl represents the implementation details of the
 * UncertaintyVariationModelGenPcm facade
 */
public class UncertaintyVariationModelGenPcmImpl {
    /**
     * Constructor
     *
     * @param scenarioManager
     * @param variationManager
     * @param logger
     */
    public UncertaintyVariationModelGenPcmImpl(final ScenarioManager scenarioManager,
            final VariationManager variationManager, final Logger logger) {
        this.scenarioManager = scenarioManager;
        this.variationManager = variationManager;
        this.logger = logger;
    }

    /**
     * generates the different scenarios, which will found under scenario directory of the current
     * project, from the pcm based on the uncertainty variation model.
     *
     * @param progressMonitor
     *            progress monitor for status reporting
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
            this.logger.error("Ressource not found", e);
        } catch (final IOException e) {
            this.logger.error("cannot write model", e);
        } catch (final IllegalStateException e) {
            this.logger.error("uncertainty variation model misformed: ", e);
        }
    }

    private final ScenarioManager scenarioManager;
    private final VariationManager variationManager;
    private final Logger logger;
}
