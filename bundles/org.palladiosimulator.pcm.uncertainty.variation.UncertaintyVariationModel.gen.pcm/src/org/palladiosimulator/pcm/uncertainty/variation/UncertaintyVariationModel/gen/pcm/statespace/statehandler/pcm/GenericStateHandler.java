package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.StateHandler;

import UncertaintyVariationModel.VariationPoint;
import de.uka.ipd.sdq.identifier.Identifier;

public abstract class GenericStateHandler implements StateHandler {
    @Override
    public abstract int getSizeOfDimension(VariationPoint variationPoint);

    @Override
    public abstract void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint,
            int variationIdx);

    protected Optional<EObject> resolve(final EObject container, final Identifier element) {
        return this.findInstance(container, currObj -> currObj instanceof Identifier,
                curr -> ((Identifier) curr).getId()
                    .equalsIgnoreCase(element.getId()));
    }

    protected Optional<EObject> resolve(final List<EObject> containers, final Identifier element) {
        Optional<EObject> resolved = Optional.empty();
        for (final EObject container : containers) {
            resolved = resolve(container, element);
            if (resolved.isPresent()) {
                break;
            }
        }

        return resolved;
    }

    protected <T extends EObject> Optional<T> findInstance(final EObject container, Predicate<EObject> typeFilter,
            Predicate<T> valueFilter) {
        T resolved = null;
        for (final TreeIterator<EObject> it = container.eAllContents(); it.hasNext();) {
            final EObject curr = it.next();
            if (!typeFilter.test(curr)) {
                continue;
            }
            @SuppressWarnings("unchecked")
            final T tmp = (T) curr;
            if (valueFilter.test(tmp)) {
                resolved = tmp;
                break;
            }
        }

        return Optional.ofNullable(resolved);
    }
}
