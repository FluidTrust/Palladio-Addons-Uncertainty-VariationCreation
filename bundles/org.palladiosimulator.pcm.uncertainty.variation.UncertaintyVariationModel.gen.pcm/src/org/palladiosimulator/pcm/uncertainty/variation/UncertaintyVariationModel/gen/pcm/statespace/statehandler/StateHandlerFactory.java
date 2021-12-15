package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler;

import UncertaintyVariationModel.VariationPoint;

public interface StateHandlerFactory {
	public StateHandler createFor(VariationPoint object);
}
