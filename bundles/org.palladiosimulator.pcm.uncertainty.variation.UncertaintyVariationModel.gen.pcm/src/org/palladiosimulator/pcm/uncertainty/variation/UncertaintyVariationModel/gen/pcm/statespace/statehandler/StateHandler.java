package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.VariationPoint;

public interface StateHandler {
	public int getSizeOfDimension(VariationPoint variationPoint);
	public void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx);
}
