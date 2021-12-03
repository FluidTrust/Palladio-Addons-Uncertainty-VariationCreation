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

public class VariationManager {
	public VariationManager(String baseUri, List<String> knownVariingModelTypes) {
		this.modelBaseUri = baseUri + "/models";
		this.scenarioBaseUri = baseUri + "/scenario";
		this.knownVariingModelTypes = knownVariingModelTypes;
		this.resourceAbstraction = new ModelResourceAbstraction(this.knownVariingModelTypes);
		this.resourceAbstraction.register(UNCERTAINTY_VARAINT_MODEL_TYPE);
	}
	
	public void createCurrVariant(int i, IProgressMonitor progressMonitor) throws CoreException {
		this.currScenarioUri = this.scenarioBaseUri + "/configuration_" + i;
		this.initializeCurrVariantFrom(this.currScenarioUri, this.modelBaseUri + "/source", progressMonitor);
	}
	
	public Map<String, List<EObject>> loadCurrVariantModels() throws CoreException {
		URI configFolderUri = URI.createURI(this.currScenarioUri);
		IPath configFolderPath = new Path(configFolderUri.toPlatformString(true));
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IFolder folder = workspace.getRoot().getFolder(configFolderPath);
		//initialize result;
		Map<String, List<EObject>> models = new HashMap<String, List<EObject>>();
		for (String modelType : this.knownVariingModelTypes) {
			models.put(modelType, new ArrayList<EObject>());
		}
		
		//for each known model load instances
		for (IResource resource : folder.members()) {
			if(models.containsKey(resource.getFileExtension())) {
				String modelUri = this.currScenarioUri + "/" + resource.getName();
				models.get(resource.getFileExtension()).add(this.resourceAbstraction.load(modelUri));
			}
		}
		
		return models;
	}
	
	public EObject loadUncertaintyVariantModel(String name) {
		String modelUri = this.modelBaseUri + "/" + name + "." + UNCERTAINTY_VARAINT_MODEL_TYPE;
		return this.resourceAbstraction.load(modelUri);
	}
	
	public void storeCurrVariantModels(Map<String, List<EObject>> models) throws IOException {
		for (List<EObject> modelsOfType : models.values()) {
			for (EObject rootElement : modelsOfType) {
				this.resourceAbstraction.save(rootElement);
			}
		}
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
	
	private final String modelBaseUri;
	private final String scenarioBaseUri;
	private final List<String> knownVariingModelTypes;
	private String currScenarioUri;
	private final ResourceAbstraction resourceAbstraction;
	private static final String UNCERTAINTY_VARAINT_MODEL_TYPE = "uncertaintyvariationmodel";
}
