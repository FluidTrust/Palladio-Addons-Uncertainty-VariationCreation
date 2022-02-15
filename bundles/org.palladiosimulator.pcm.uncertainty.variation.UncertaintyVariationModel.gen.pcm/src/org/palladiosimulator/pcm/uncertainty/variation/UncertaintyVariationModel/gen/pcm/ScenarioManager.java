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
import org.eclipse.net4j.util.om.monitor.SubMonitor;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;

/**
 * ScenarioManager realizes the management of the scenarios generated from the pcm through the
 * uncertainty variation model.
 */
public class ScenarioManager {
    /**
     * Constructor
     *
     * @param modelBaseUri
     *            specifies the uniform resource identifier (uri) which points to the folder in
     *            which the uncertainty variation model is contained. The uri must be of the
     *            platform type. The pcm base models will be searched in the source subdirectory of
     *            the uri and the scenarios will be generated under the ../scenario subdirectory of
     *            the uri.
     * @throws CoreException
     *             if result directory can not be created in the case it does not exist
     */
    public ScenarioManager(final URI modelBaseUri) throws CoreException {
        this.modelBaseUri = modelBaseUri.appendSegment("source");
        this.scenarioBaseUri = modelBaseUri.trimSegments(1)
            .appendSegment("scenario");
        this.createFolder(scenarioBaseUri);
    }

    /**
     * createCurrVariant generates variant i from the base models by copying the files into
     * configuration_i subdirectory of the scenario folder of the current project.
     *
     * @param i
     *            specifies the id number of the current variant
     *
     * @param progressMonitor
     * @throws CoreException
     *             if existing configuration cannot be deleted or new configuration cannot be
     *             generated
     */
    public void createCurrVariant(final int i, final IProgressMonitor progressMonitor) throws CoreException {
        this.currScenarioUri = this.scenarioBaseUri.appendSegment("configuration_" + i);
        this.initializeCurrVariantFrom(this.currScenarioUri, this.modelBaseUri, progressMonitor);
    }

    /**
     * register registers the known varying model types of the pcm for later loading.
     *
     * @param knownVariingModelTypes
     *            specifies a list with the names of the known model that should be varied.
     */
    public void register(final List<String> knownVariingModelTypes) {
        this.knownVariingModelTypes = knownVariingModelTypes;
        this.resourceAbstraction = new ModelResourceAbstraction(this.knownVariingModelTypes);
    }

    /**
     * loadCurrVariantModels loads and returns the different pcm models that must be varied of the
     * current variant. This function requires a single call of the function register and a call of
     * the function createCurrVariant.
     *
     * @return a map between model type as string and loaded models of this type
     * @throws CoreException
     */
    public Map<String, List<EObject>> loadCurrVariantModels() throws CoreException {
        final IFolder folder = translateUriToFolder(currScenarioUri);
        // initialize result;
        final Map<String, List<EObject>> models = new HashMap<String, List<EObject>>();
        for (final String modelType : this.knownVariingModelTypes) {
            models.put(modelType, new ArrayList<EObject>());
        }

        // for each known model load instances
        for (final IResource resource : folder.members()) {
            if (models.containsKey(resource.getFileExtension())) {
                final URI modelUri = this.currScenarioUri.appendSegment(resource.getName());
                models.get(resource.getFileExtension())
                    .add(this.resourceAbstraction.load(modelUri));
            }
        }

        return models;
    }

    /**
     * storeCurrVariantModels store the pcm models that were loaded with the function
     * loadCurrVariantModels.
     *
     * @param models
     *            specifies the models that shall be stored
     * @throws IOException
     */
    public void storeCurrVariantModels(final Map<String, List<EObject>> models) throws IOException {
        for (final List<EObject> modelsOfType : models.values()) {
            for (final EObject rootElement : modelsOfType) {
                this.resourceAbstraction.save(rootElement);
            }
        }
    }

    /**
     * getCurrScenarioUri returns the uri of the current variant generated by the function
     * createCurrVariant.
     *
     * return the platform uri to the current variant.
     */
    public URI getCurrScenarioUri() {
        return this.currScenarioUri;
    }

    private void initializeCurrVariantFrom(final URI configurationUri, final URI srcUri,
            final IProgressMonitor progressMonitor) throws CoreException {
        final SubMonitor progressSubMonitor = SubMonitor.convert(progressMonitor, 100);

        final IFolder srcFolder = translateUriToFolder(srcUri);
        final IFolder configurationFolder = translateUriToFolder(configurationUri);
        if (configurationFolder.exists()) {
            configurationFolder.delete(true, progressSubMonitor.newChild(50));
        }

        final IPath configurationPath = new Path(configurationUri.toPlatformString(true));
        srcFolder.copy(configurationPath, true, progressSubMonitor.newChild(50));
        progressSubMonitor.done();
    }

    private IFolder translateUriToFolder(final URI uri) {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IPath path = new Path(uri.toPlatformString(true));
        final IFolder folder = workspace.getRoot()
            .getFolder(path);
        return folder;
    }

    private void createFolder(final URI uri) throws CoreException {
        IFolder folder = translateUriToFolder(uri);
        if (!folder.exists()) {
            folder.create(false, false, null);
        }
    }

    private final URI modelBaseUri;
    private final URI scenarioBaseUri;
    private List<String> knownVariingModelTypes;
    private URI currScenarioUri;
    private ResourceAbstraction resourceAbstraction;
}
