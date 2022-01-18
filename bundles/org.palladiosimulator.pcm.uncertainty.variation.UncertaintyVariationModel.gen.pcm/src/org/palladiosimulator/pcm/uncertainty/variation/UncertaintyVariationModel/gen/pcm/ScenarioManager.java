package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;

public class ScenarioManager {
    public ScenarioManager(final String baseUri, final List<String> knownVariingModelTypes) {
        this.modelBaseUri = baseUri + "/models";
        this.scenarioBaseUri = baseUri + "/scenario";
        this.knownVariingModelTypes = knownVariingModelTypes;
        this.resourceAbstraction = new ModelResourceAbstraction(this.knownVariingModelTypes);
    }

    public void createCurrVariant(final int i, final IProgressMonitor progressMonitor) throws CoreException {
        this.currScenarioUri = this.scenarioBaseUri + "/configuration_" + i;
        this.initializeCurrVariantFrom(this.currScenarioUri, this.modelBaseUri + "/source", progressMonitor);
    }

    public Map<String, List<EObject>> loadCurrVariantModels() throws CoreException {
        final URI configFolderUri = URI.createURI(this.currScenarioUri);
        final IPath configFolderPath = new Path(configFolderUri.toPlatformString(true));
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IFolder folder = workspace.getRoot()
            .getFolder(configFolderPath);
        // initialize result;
        final Map<String, List<EObject>> models = new HashMap<String, List<EObject>>();
        for (final String modelType : this.knownVariingModelTypes) {
            models.put(modelType, new ArrayList<EObject>());
        }

        // for each known model load instances
        for (final IResource resource : folder.members()) {
            if (models.containsKey(resource.getFileExtension())) {
                final String modelUri = this.currScenarioUri + "/" + resource.getName();
                models.get(resource.getFileExtension())
                    .add(this.resourceAbstraction.load(modelUri));
            }
        }

        return models;
    }

    public void storeCurrVariantModels(final Map<String, List<EObject>> models) throws IOException {
        for (final List<EObject> modelsOfType : models.values()) {
            for (final EObject rootElement : modelsOfType) {
                this.resourceAbstraction.save(rootElement);
            }
        }
    }

    public String getCurrScenarioUri() {
        return this.currScenarioUri;
    }

    private void initializeCurrVariantFrom(final String configurationUri, final String srcUri,
            final IProgressMonitor progressMonitor) throws CoreException {
        final URI folderUri = URI.createURI(srcUri);
        final IPath folderPath = new Path(folderUri.toPlatformString(true));

        final URI configFolderUri = URI.createURI(configurationUri);
        final IPath configFolderPath = new Path(configFolderUri.toPlatformString(true));

        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IFolder folder = workspace.getRoot()
            .getFolder(folderPath);

        final IFolder configFolder = workspace.getRoot()
            .getFolder(configFolderPath);
        if (configFolder.exists()) {
            configFolder.delete(true, progressMonitor);
        }

        folder.copy(configFolderPath, true, progressMonitor);
    }

    private final String modelBaseUri;
    private final String scenarioBaseUri;
    private final List<String> knownVariingModelTypes;
    private String currScenarioUri;
    private final ResourceAbstraction resourceAbstraction;
}
