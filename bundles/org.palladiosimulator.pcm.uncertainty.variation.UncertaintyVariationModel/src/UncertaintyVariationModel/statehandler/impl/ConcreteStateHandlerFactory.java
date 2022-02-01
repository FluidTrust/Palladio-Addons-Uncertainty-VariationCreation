package UncertaintyVariationModel.statehandler.impl;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.StateHandler;
import UncertaintyVariationModel.statehandler.StateHandlerFactory;
import UncertaintyVariationModel.statehandler.util.StateHandlerImplementation;

public class ConcreteStateHandlerFactory implements StateHandlerFactory {
    public ConcreteStateHandlerFactory() {
    }

    public static StateHandlerFactory init() {
        return new ConcreteStateHandlerFactory();
    }

    @Override
    public StateHandler createFor(final VariationPoint object) {
        String stateHandlerId = object.getStateHandlerId();
        StateHandlerImplementation impl = new StateHandlerImplementation();
        return impl.getImplemationOf(stateHandlerId)
            .orElseThrow(() -> new UnsupportedOperationException("Unknown stateHandlerId " + stateHandlerId));
    }
}
