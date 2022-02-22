package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
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
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;

/**
 * ConcreteScenarioManager realizes the management of the scenarios generated from the pcm through
 * the uncertainty variation model.
 */
public class ConcreteScenarioManager implements ScenarioManager {
    /**
     * Constructor
     *
     * @param modelBaseUri
     *            specifies the uniform resource identifier (uri) which points to the folder in
     *            which the uncertainty variation model is contained. The uri must be of the
     *            platform type. The pcm base models will be searched in the sourceDir sub-directory
     *            of the uri and the scenarios will be generated under the ../resultDir
     *            sub-directory of the uri.
     * @param sourceDirName
     *            name of the directory in which the model templates for the variants will be
     *            searched in.
     * @param resultDirName
     *            name of the directory in which the all variants will be saved in
     * @param variantDirName
     *            name of the directory in which one variant will be saved in
     * @throws CoreException
     *             if result directory can not be created in the case it does not exist
     */
    public ConcreteScenarioManager(final URI modelBaseUri, final String sourceDirName, final String resultDirName,
            final String variantDirName) throws CoreException {
        this.modelBaseUri = modelBaseUri.appendSegment(sourceDirName);
        this.scenariosBaseUri = modelBaseUri.trimSegments(1)
            .appendSegment(resultDirName);
        this.createFolder(this.scenariosBaseUri);
        this.createCsvFile(this.scenariosBaseUri);
        this.variantPrefixName = variantDirName + "_";
    }

    /**
     * generates variant i from the base models by copying the files into configuration_i
     * subdirectory of the scenario folder of the current project.
     *
     * @param idx
     *            specifies the id number of the current variant
     * @param progressMonitor
     *            progress monitor for status reporting
     * @throws CoreException
     *             if existing configuration cannot be deleted or new configuration cannot be
     *             generated
     */
    @Override
    public void createCurrVariant(final int idx, final IProgressMonitor progressMonitor) throws CoreException {
        this.setCurrVariantUri(idx);
        this.initializeCurrVariantFrom(this.getCurrVariantUri(), this.modelBaseUri, progressMonitor);
    }

    /**
     * registers the known varying model types of the pcm for later loading.
     *
     * @param knownVariingModelTypes
     *            specifies a list with the names of the known model that should be varied.
     */
    @Override
    public void register(final List<String> knownVariingModelTypes) {
        this.knownVariingModelTypes = knownVariingModelTypes;
        this.resourceAbstraction = new ModelResourceAbstraction(this.knownVariingModelTypes);
    }

    /**
     * loads and returns the different pcm models that must be varied of the current variant. This
     * function requires a single call of the function register and a call of the function
     * createCurrVariant.
     *
     * @return a map between model type as string and loaded models of this type
     * @throws CoreException
     *             if the result directory or its content can not be reached
     */
    @Override
    public Map<String, List<EObject>> loadCurrVariantModels() throws CoreException {
        final IFolder folder = this.translateUriToFolder(this.getCurrVariantUri());
        // initialize result;
        final Map<String, List<EObject>> models = new HashMap<String, List<EObject>>();
        for (final String modelType : this.knownVariingModelTypes) {
            models.put(modelType, new ArrayList<EObject>());
        }

        // for each known model load instances
        for (final IResource resource : folder.members()) {
            if (models.containsKey(resource.getFileExtension())) {
                final URI modelUri = this.getCurrVariantUri()
                    .appendSegment(resource.getName());
                models.get(resource.getFileExtension())
                    .add(this.resourceAbstraction.load(modelUri));
            }
        }

        return models;
    }

    /**
     * store the pcm models that were loaded with the function loadCurrVariantModels.
     *
     * @param models
     *            specifies the models that shall be stored
     * @throws IOException
     *             if writing of one of the models fails
     */
    @Override
    public void storeCurrVariantModels(final Map<String, List<EObject>> models) throws IOException {
        for (final List<EObject> modelsOfType : models.values()) {
            for (final EObject rootElement : modelsOfType) {
                this.resourceAbstraction.save(rootElement);
            }
        }
    }

    /**
     * returns the uri of the current variant generated by the function createCurrVariant.
     *
     * return the platform uri to the current variant.
     */
    @Override
    public URI getCurrVariantUri() {
        return this.currVariantUri;
    }

    /**
     * writes the different variation points into the report
     *
     * @param statespace
     *            the statespace to report
     * @param progressMonitor
     *            progress monitor for status reporting
     * @throws CoreException
     *             if the writing into the report fails
     */
    @Override
    public void reportsVariationPoints(final Statespace statespace, final IProgressMonitor progressMonitor)
            throws CoreException {
        final List<String> columns = new ArrayList<>();
        columns.add("variations");
        columns.addAll(statespace.getDimensions());

        final String content = String.join(";", columns) + "\n";

        final InputStream stream = new ByteArrayInputStream(content.getBytes());
        this.csvReport.appendContents(stream, 0, progressMonitor);
    }

    /**
     * writes the current state of the statespace iterator into the report
     *
     * @param it
     *            the StatespaceIterator to report
     * @param progressMonitor
     *            progress monitor for status reporting
     * @throws CoreException
     *             if the writing into the report fails
     */
    @Override
    public void reportVariation(final StatespaceIterator it, final IProgressMonitor progressMonitor)
            throws CoreException {
        final List<String> columns = new ArrayList<>();
        columns.add(this.getCurrVariantUri()
            .lastSegment());
        columns.addAll(it.getCurrentState());

        final String content = String.join(";", columns) + "\n";

        final InputStream stream = new ByteArrayInputStream(content.getBytes());
        this.csvReport.appendContents(stream, 0, progressMonitor);
    }

    private void setCurrVariantUri(final int idx) {
        this.currVariantUri = this.scenariosBaseUri.appendSegment(this.variantPrefixName + idx);
    }

    // creates a new variant directory and copies the model templates into it
    private void initializeCurrVariantFrom(final URI configurationUri, final URI srcUri,
            final IProgressMonitor progressMonitor) throws CoreException {
        final SubMonitor progressSubMonitor = SubMonitor.convert(progressMonitor, 100);

        final IFolder srcFolder = this.translateUriToFolder(srcUri);
        final IFolder configurationFolder = this.translateUriToFolder(configurationUri);
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
        final IFolder folder = this.translateUriToFolder(uri);
        if (!folder.exists()) {
            folder.create(true, true, null);
        }
    }

    private void createCsvFile(final URI uri) throws CoreException {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        final LocalDateTime now = LocalDateTime.now();
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final URI csv = uri.appendSegment("report_" + dtf.format(now) + ".csv");
        final IPath path = new Path(csv.toPlatformString(true));
        this.csvReport = workspace.getRoot()
            .getFile(path);

        final String content = "";
        final InputStream stream = new ByteArrayInputStream(content.getBytes());
        this.csvReport.create(stream, false, null);
    }

    private final String variantPrefixName;
    private final URI modelBaseUri;
    private final URI scenariosBaseUri;
    private List<String> knownVariingModelTypes;
    private URI currVariantUri;
    private ResourceAbstraction resourceAbstraction;
    private IFile csvReport;
}
