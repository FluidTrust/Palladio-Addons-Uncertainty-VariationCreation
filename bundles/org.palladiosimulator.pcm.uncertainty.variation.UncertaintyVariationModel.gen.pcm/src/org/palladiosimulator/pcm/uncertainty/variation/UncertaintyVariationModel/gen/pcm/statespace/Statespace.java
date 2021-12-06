package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.AllocationStateHandler;

import UncertaintyVariationModel.UncertaintyVariations;

public class Statespace {
	public Statespace(EObject uncertaintyVariations) {
		this.uncertaintyVariations = (UncertaintyVariations)uncertaintyVariations;
		this.stateHandlers = new ArrayList<>();
		for (int i = 0; i < this.getNumberOfDimensions(); ++i)
			this.stateHandlers.add(new AllocationStateHandler());
	}
	
	public Iterator iterator() { return new StatespaceItertator(this); }
	public void patchModelsWith(Map<String, List<EObject>> models, int dimension, int variationIdx) {
		this.stateHandlers.get(dimension).patchModelWith(models, this.uncertaintyVariations.getVariationPoints().get(dimension), variationIdx);
	}
	
	public int getNumberOfDimensions() { return uncertaintyVariations.getVariationPoints().size(); }
	public int getSizeOfDimension(int dimension) { 
		return this.stateHandlers.get(dimension).getSizeOfDimension(this.uncertaintyVariations.getVariationPoints().get(dimension)); 
	}
	
	private UncertaintyVariations uncertaintyVariations;
	private List<StateHandler> stateHandlers;

}
