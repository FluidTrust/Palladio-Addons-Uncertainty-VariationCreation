package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandlerFactory;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.VaryingAllocationContext;
import UncertaintyVariationModel.VaryingAssemblyContext;
import UncertaintyVariationModel.VaryingBranch;
import UncertaintyVariationModel.util.UncertaintyVariationModelSwitch;

public class ConcreteStateHandlerFactory extends UncertaintyVariationModelSwitch<StateHandler> implements StateHandlerFactory {
    public ConcreteStateHandlerFactory() {}
	
	@Override
	public StateHandler createFor(VariationPoint object) {
		return doSwitch(object);
	}
	
	@Override
	public StateHandler caseVaryingAllocationContext(VaryingAllocationContext object) {
		return new AllocationStateHandler();
	}
	
	@Override
	public StateHandler caseVaryingBranch(VaryingBranch object) {
		return new BranchStateHandler();
	}
	
	@Override
	public StateHandler caseVaryingAssemblyContext(VaryingAssemblyContext object) {
		return new AssemblyStateHandler();
	}

}
