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

/**
 * UncertaintyVariationModelGenPcm realizes the generation of the uncertainty varied palladio
 * component model (pcm) based the specified uncertainty variation model.
 */
public class UncertaintyVariationModelGenPcm {
    /**
     * Constructor
     *
     * @param baseUri
     *            specifies the uniform resource identifier (uri) which points to the base project
     *            for the varying. The uri must be of the platform type.
     */
    public UncertaintyVariationModelGenPcm(final String baseUri) {
        this.scenarioManager = new ScenarioManager(baseUri);
        this.variationManager = new VariationManager(baseUri);
    }

    /**
     * generateVariations generates the different scenarios, which will found under scenario
     * directory of the current project, from the pcm based on the uncertainty variation model.
     *
     * @param progressMonitor
     */
    public void generateVariations(final IProgressMonitor progressMonitor) {
        final SubMonitor progressSubMonitor = SubMonitor.convert(progressMonitor);
        final Statespace statespace = new Statespace(this.variationManager.loadUncertaintyVariantModel("port"));
        this.scenarioManager.register(statespace.getModelTypes());

        int i = 0;
        for (final StatespaceIterator it = statespace.iterator(); it.hasNext(); it.next()) {
            try {
                final SubMonitor iterationMonitor = progressSubMonitor.setWorkRemaining(100)
                    .newChild(1);
                iterationMonitor.subTask("generating scenario " + i);
                this.scenarioManager.createCurrVariant(i, iterationMonitor);
                final Map<String, List<EObject>> models = this.scenarioManager.loadCurrVariantModels();
                it.patchModels(models);
                this.scenarioManager.storeCurrVariantModels(models);
                ++i;
            } catch (final CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private final ScenarioManager scenarioManager;
    private final VariationManager variationManager;
}
