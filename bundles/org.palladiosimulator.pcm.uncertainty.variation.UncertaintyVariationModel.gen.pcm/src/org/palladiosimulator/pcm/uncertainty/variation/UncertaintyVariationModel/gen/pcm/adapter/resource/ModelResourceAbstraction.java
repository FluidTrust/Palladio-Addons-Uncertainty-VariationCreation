package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelResourceAbstraction implements ResourceAbstraction {
	public ModelResourceAbstraction(List<String> knownModelTypes) {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getContentTypeToFactoryMap();
		for (String model : knownModelTypes) {
			m.put(model, new XMIResourceFactoryImpl());
		}
	}
	
	@Override
	public EObject load(String modelUri) {
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(URI.createURI(modelUri), true);
		
		return res.getContents().get(0);
	}
	
	@Override
	public void save(EObject rootElement) throws IOException {
		Resource res = rootElement.eResource();
		res.save(Collections.EMPTY_MAP);	
	}

	@Override
	public void register(String modelType) {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getContentTypeToFactoryMap();
		m.put(modelType, new XMIResourceFactoryImpl());
	}
}
