package UncertaintyVariationModel.statehandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import UncertaintyVariationModel.VariationPoint;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * GenericStateHandler realizes the abstract base class for StateHandler.
 */
public abstract class GenericStateHandler implements StateHandler {
    @Override
    public abstract int getSizeOfDimension(VariationPoint variationPoint);

    @Override
    public abstract void patchModelWith(Map<String, List<EObject>> models, VariationPoint variationPoint,
            int variationIdx);

    /**
     * resolve finds an optional model element in the container that corresponds to element.
     * 
     * @param container
     *            the container to search in
     * @param element
     * @return the model element that corresponds the element or empty
     */
    protected Optional<EObject> resolve(final EObject container, final Identifier element) {
        return this.findInstance(container, currObj -> currObj instanceof Identifier,
                curr -> ((Identifier) curr).getId()
                    .equalsIgnoreCase(element.getId()));
    }

    protected List<Optional<EObject>> reslove(final EObject container, final List<Identifier> elements) {
        List<Optional<EObject>> result = new ArrayList<>();
        for (final Identifier element : elements) {
            result.add(this.resolve(container, element));
        }

        return result;
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

    /**
     * 
     * @param containers
     * @param elements
     * @return
     */
    protected List<Optional<EObject>> resolve(final List<EObject> containers, final List<Identifier> elements) {
        List<Optional<EObject>> result = new ArrayList<>();
        for (final Identifier element : elements) {
            result.add(this.resolve(containers, element));
        }
        return result;
    }

    /**
     * findInstance finds an optional model element in the container that fulfills the type filter
     * and the valueFilter.
     * 
     * @param <T>
     *            the type of the model element
     * @param container
     *            the container to search in
     * @param typeFilter
     *            predicate to filter elements in the container with a type expression
     * @param valueFilter
     *            predicate to filter elements in the container with attribute values. It is used
     *            after the typeFilter.
     * @return the model element that fits the filter or empty
     */
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
