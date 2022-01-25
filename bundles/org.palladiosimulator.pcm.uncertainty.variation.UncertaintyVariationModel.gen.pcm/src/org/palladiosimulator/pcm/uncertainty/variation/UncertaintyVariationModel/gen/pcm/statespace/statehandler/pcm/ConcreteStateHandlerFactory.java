package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandlerFactory;

import UncertaintyVariationModel.VariationPoint;

public class ConcreteStateHandlerFactory implements StateHandlerFactory {
    public ConcreteStateHandlerFactory() {
    }

    @Override
    public StateHandler createFor(final VariationPoint object) {
        String stateHandlerId = object.getStateHandlerId();
        if (stateHandlerId.equalsIgnoreCase("AllocationStateHandler")) {
            return new AllocationStateHandler();
        } else if (stateHandlerId.equalsIgnoreCase("BranchStateHandler")) {
            return new BranchStateHandler();
        } else if (stateHandlerId.equalsIgnoreCase("AssemblyStateHandler")) {
            return new AssemblyStateHandler();
        } else if (stateHandlerId.equalsIgnoreCase("CharacteristicsStateHandler")) {
            return new CharacteristicsStateHandler();
        } else {
            throw new UnsupportedOperationException("Unknown stateHandlerId " + stateHandlerId);
        }
    }
}
