package org.palladiosimulator.pcm.uncertainty.variation.dsl.UncertaintyVariationModel.gen.pcm.adapter.resource;

import org.eclipse.emf.ecore.EObject;

public interface ResourceAbstraction {

	//template-method
	void copy(String destModelUri, String srcModelUri);

	//template-method
	EObject load(String modelUri);

	//template-method
	void save(String modelUri, EObject rootElement);

}