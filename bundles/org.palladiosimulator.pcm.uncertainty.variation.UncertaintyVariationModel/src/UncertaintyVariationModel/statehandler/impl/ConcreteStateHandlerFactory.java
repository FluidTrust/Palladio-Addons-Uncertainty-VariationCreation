package UncertaintyVariationModel.statehandler.impl;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.StateHandler;
import UncertaintyVariationModel.statehandler.StateHandlerFactory;
import UncertaintyVariationModel.statehandler.util.StateHandlerImplementation;

/**
 * ConcreteStateHandlerFactory realizes the concrete factory implementation.
 */
public class ConcreteStateHandlerFactory implements StateHandlerFactory {
    /**
     * Constructor
     */
    private ConcreteStateHandlerFactory() {
    }

    /**
     * creates and return the instance of the concrete StateHandlerFactory.
     * 
     * @return the created concrete StateHandlerFactory
     */
    public static StateHandlerFactory init() {
        return new ConcreteStateHandlerFactory();
    }

    @Override
    public StateHandler createFor(final VariationPoint object) {
        String stateHandlerId = object.getStateHandlerId();
        StateHandlerImplementation impl = new StateHandlerImplementation();
        return impl.getImplemationOf(stateHandlerId)
            .orElseThrow(() -> new IllegalStateException("Unknown stateHandlerId " + stateHandlerId));
    }
}
