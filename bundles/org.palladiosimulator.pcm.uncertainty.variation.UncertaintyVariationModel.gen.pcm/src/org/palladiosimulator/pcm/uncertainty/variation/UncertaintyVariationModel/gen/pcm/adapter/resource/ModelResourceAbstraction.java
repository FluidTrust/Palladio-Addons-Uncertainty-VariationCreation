package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class ModelResourceAbstraction implements ResourceAbstraction {
	public ModelResourceAbstraction() { }
	
	//template-method
	@Override
	public void copy(String destModelUri, String srcModelUri) {
		URI srcUri = URI.createURI(srcModelUri);
		srcUri = srcUri.appendFileExtension(this.getModelName());
		String srcFile = srcUri.toPlatformString(true);
		IPath srcPath = new Path(srcFile);
		
		URI destUri = URI.createURI(destModelUri + "/" + srcUri.lastSegment());
		String destFile = destUri.toPlatformString(true);
		IPath destPath = new Path(destFile);
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IFile file = workspace.getRoot().getFile(srcPath);
		try {
			IFile dest = workspace.getRoot().getFile(destPath);
			if (dest.exists()) {
				dest.delete(true, null);
			}
			if (!dest.getParent().exists()) {
				((IFolder)dest.getParent().getParent()).getFolder(dest.getParent().getName()).create(true, true, null);
			}
			
			file.copy(destPath, true, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//template-method
	@Override
	public EObject load(String modelUri) {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getContentTypeToFactoryMap();
		m.put(this.getModelName(), new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(URI.createURI(modelUri).appendFileExtension(this.getModelName()), true);
		
		return res.getContents().get(0);
	}
	
	//template-method
	@Override
	public void save(String modelUri, EObject rootElement) {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getContentTypeToFactoryMap();
		m.put(this.getModelName(), new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.createResource(URI.createURI(modelUri).appendFileExtension(this.getModelName()));
		res.getContents().add(rootElement);
		
		// now save the content.
        try {
            res.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
	}
	
	protected abstract String getModelName();
}
