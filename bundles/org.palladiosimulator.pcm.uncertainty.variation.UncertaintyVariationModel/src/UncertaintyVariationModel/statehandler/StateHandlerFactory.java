package UncertaintyVariationModel.statehandler;

import UncertaintyVariationModel.VariationPoint;

/**
 * StateHandlerFactory describes a factory for the creation of StateHandler implementations.
 */
public interface StateHandlerFactory {
    /**
     * is the singleton instance of the concrete StateHandlerFactory.
     */
    StateHandlerFactory INSTANCE = UncertaintyVariationModel.statehandler.impl.ConcreteStateHandlerFactory.init();

    /**
     * creates and returns the StateHandler implementation corresponding to the VariationPoint.
     * 
     * @param object
     *            the current VariationPoint
     * @return the created StateHandler implementation
     * @throws IllegalStateException
     *             if no StateHandlerImplementation can be created
     */
    public StateHandler createFor(VariationPoint object);
}
