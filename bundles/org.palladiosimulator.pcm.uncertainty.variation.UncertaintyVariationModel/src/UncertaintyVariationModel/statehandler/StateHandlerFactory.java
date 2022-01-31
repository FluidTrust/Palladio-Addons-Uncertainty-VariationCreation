package UncertaintyVariationModel.statehandler;

import UncertaintyVariationModel.VariationPoint;

public interface StateHandlerFactory {
    StateHandlerFactory INSTANCE = UncertaintyVariationModel.statehandler.impl.ConcreteStateHandlerFactory
        .init();

    public StateHandler createFor(VariationPoint object);
}
