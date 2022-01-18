package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandlerFactory;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.VaryingAllocationContext;
import UncertaintyVariationModel.VaryingAssemblyContext;
import UncertaintyVariationModel.VaryingBranch;
import UncertaintyVariationModel.util.UncertaintyVariationModelSwitch;

public class ConcreteStateHandlerFactory extends UncertaintyVariationModelSwitch<StateHandler>
        implements StateHandlerFactory {
    public ConcreteStateHandlerFactory() {
    }

    @Override
    public StateHandler createFor(final VariationPoint object) {
        return this.doSwitch(object);
    }

    @Override
    public StateHandler caseVaryingAllocationContext(final VaryingAllocationContext object) {
        return new AllocationStateHandler();
    }

    @Override
    public StateHandler caseVaryingBranch(final VaryingBranch object) {
        return new BranchStateHandler();
    }

    @Override
    public StateHandler caseVaryingAssemblyContext(final VaryingAssemblyContext object) {
        return new AssemblyStateHandler();
    }

}
