package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.AllocationStateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.AssemblyStateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.BranchStateHandler;

public class UncertaintyVariationModelGenPcm {
    public UncertaintyVariationModelGenPcm(final String baseUri) {
        final List<String> models = new ArrayList<>();
        models.addAll(AllocationStateHandler.getModelTypes());
        models.addAll(BranchStateHandler.getModelTypes());
        models.addAll(AssemblyStateHandler.getModelTypes());

        this.scenarioManager = new ScenarioManager(baseUri, models);
        this.variationManager = new VariationManager(baseUri);
    }

    public void generateVariations(final IProgressMonitor progressMonitor) {
        final Statespace statespace = new Statespace(this.variationManager.loadUncertaintyVariantModel("port"));
        progressMonitor.beginTask("creating variations", IProgressMonitor.UNKNOWN);
        int i = 0;
        for (final StatespaceIterator it = statespace.iterator(); it.hasNext(); it.next()) {
            try {
                this.scenarioManager.createCurrVariant(i, progressMonitor);
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
        progressMonitor.done();
    }

    private final ScenarioManager scenarioManager;
    private final VariationManager variationManager;
}
