package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;

import UncertaintyVariationModel.VariationPoint;
import de.uka.ipd.sdq.identifier.Identifier;

public abstract class GenericStateHandler implements StateHandler {
	@Override
	public abstract int getSizeOfDimension(VariationPoint variationPoint);
	
	@Override
	public abstract void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint, int variationIdx);
	
	
	protected Optional<EObject> resolve(EObject container, Identifier element) {
		EObject resolved = null;
		for (TreeIterator<EObject> it = container.eAllContents(); it.hasNext();) {
			EObject curr = it.next();
			if (!(curr instanceof Identifier))
				continue;
			if (((Identifier)curr).getId().equalsIgnoreCase(element.getId())) {
				resolved = curr;
				break;
			}
		}
		
		return Optional.ofNullable(resolved);
	}
	
	protected Optional<EObject> resolve(List<EObject> containers, Identifier element) {
		EObject resolved = null;
		for (EObject container: containers) {
			for (TreeIterator<EObject> it = container.eAllContents(); it.hasNext();) {
				EObject curr = it.next();
				if (!(curr instanceof Identifier))
					continue;
				if (((Identifier)curr).getId().equalsIgnoreCase(element.getId())) {
					resolved = curr;
					break;
				}
			}
		}
		
		return Optional.ofNullable(resolved);
	}
}
