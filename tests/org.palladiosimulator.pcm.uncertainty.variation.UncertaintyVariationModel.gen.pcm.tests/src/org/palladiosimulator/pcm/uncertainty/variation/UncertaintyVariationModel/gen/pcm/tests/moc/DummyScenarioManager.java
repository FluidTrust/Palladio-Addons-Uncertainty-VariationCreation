package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests.moc;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ScenarioManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;

public class DummyScenarioManager implements ScenarioManager {
    public DummyScenarioManager(final URI modelBaseUri, final String sourceDirName, final List<URI> content) {
        this.modelBaseUri = modelBaseUri.appendSegment(sourceDirName);
        this.content = content;
        this.results = new ArrayList<>();
        this.resourceAbstraction = new ModelResourceAbstraction();
    }

    @Override
    public void createCurrVariant(final int idx, final IProgressMonitor progressMonitor) throws CoreException {
        // Dummy has here nothing to do
    }

    @Override
    public void register(final List<String> knownVariingModelTypes) {
        this.knownVariingModelTypes = knownVariingModelTypes;
        this.resourceAbstraction.updateRegisteredModels(this.knownVariingModelTypes);
    }

    @Override
    public Map<String, List<EObject>> loadCurrVariantModels() throws CoreException {
        // initialize result;
        final Map<String, List<EObject>> models = new HashMap<String, List<EObject>>();
        for (final String modelType : this.knownVariingModelTypes) {
            models.put(modelType, new ArrayList<EObject>());
        }

        // for each known model load instances
        for (final URI resource : this.content) {
            if (models.containsKey(resource.fileExtension())) {
                final URI modelUri = this.getCurrVariantUri()
                    .appendSegments(resource.segments());
                models.get(resource.fileExtension())
                    .add(this.resourceAbstraction.load(modelUri));
            }
        }

        return models;
    }

    @Override
    public void storeCurrVariantModels(final Map<String, List<EObject>> models) throws IOException {
        this.results.add(models);
    }

    @Override
    public URI getCurrVariantUri() {
        return this.modelBaseUri;
    }

    private final URI modelBaseUri;
    private List<String> knownVariingModelTypes;
    private ResourceAbstraction resourceAbstraction;
    private final List<Map<String, List<EObject>>> results;
    private final List<URI> content;

    public List<Map<String, List<EObject>>> getResults() {
        return this.results;
    }

    @Override
    public void reportsVariationPoints(final Statespace statespace, final IProgressMonitor progressMonitor)
            throws CoreException {
        final var headers = statespace.getDimensions();
        assertTrue(!headers.isEmpty());
    }

    @Override
    public void reportVariation(final StatespaceIterator it, final IProgressMonitor progressMonitor)
            throws CoreException {
        final var columnsCompact = it.getCurrentState();
        assertTrue(!columnsCompact.isEmpty());
        final var columnsVerbose = it.getCurrentStateValue();
        assertTrue(!columnsVerbose.isEmpty());
    }
}
