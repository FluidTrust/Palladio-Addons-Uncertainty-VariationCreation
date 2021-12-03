package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import org.eclipse.emf.ecore.EObject;

public interface ResourceAbstraction {
	//template-method
	EObject load(String modelUri);

	//template-method
	void save(String modelUri, EObject rootElement);

}