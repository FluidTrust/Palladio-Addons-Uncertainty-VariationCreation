package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class VariationManager {
	public VariationManager(String baseUri) {
		this.modelBaseUri = baseUri + "/models";
		this.scenarioBaseUri = baseUri + "/scenario";
	}
	
	public void createCurrVariant(int i, IProgressMonitor progressMonitor) throws CoreException {
		this.currScenarioUri = this.scenarioBaseUri + "/configuration_" + i;
		this.initializeCurrVariantFrom(this.currScenarioUri, this.modelBaseUri + "/source", progressMonitor);
	}
	
	public String getCurrScenatioUri() {
		return this.currScenarioUri;
	}
		
	private void initializeCurrVariantFrom(String configurationUri, String srcUri, IProgressMonitor progressMonitor) throws CoreException {
		URI folderUri = URI.createURI(srcUri);
		IPath folderPath = new Path(folderUri.toPlatformString(true));
		
		URI configFolderUri = URI.createURI(configurationUri);
		IPath configFolderPath = new Path(configFolderUri.toPlatformString(true));
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IFolder folder = workspace.getRoot().getFolder(folderPath);
		
		IFolder configFolder = workspace.getRoot().getFolder(configFolderPath);
		if (configFolder.exists())
			configFolder.delete(true, progressMonitor);
		
		folder.copy(configFolderPath, true, progressMonitor);
	}
	
	private String modelBaseUri;
	private String scenarioBaseUri;
	private String currScenarioUri;
}
