package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

/**
 * ConcreteStatespaceItertator is a concrete realization of the StatespaceIterator
 */
class ConcreteStatespaceItertator implements StatespaceIterator {
    /**
     * Constructor
     *
     * @param statespace
     *            the statespace to traversal
     */
    public ConcreteStatespaceItertator(final Statespace statespace) {
        this.statespace = statespace;
        this.indices = new ArrayList<Integer>();
        for (int i = 0; i < this.statespace.getNumberOfDimensions(); ++i) {
            this.indices.add(0);
        }
    }

    @Override
    public boolean hasNext() {
        boolean result = this.statespace.getNumberOfDimensions() > 0;
        // test all dimension, nothing to traversal when last dimension overflows
        for (int i = 0; i < this.indices.size(); ++i) {
            result = result && (this.indices.get(i) < this.statespace.getSizeOfDimension(i));
        }

        return result;
    }

    @Override
    public void next() {
        if (!this.hasNext()) {
            return;
        }

        // serializes dimensions into ascending order: first dimension traversal first and last
        // dimension traversal last
        for (int i = 0; i < this.indices.size(); ++i) {
            // advance position in dimension
            int currIdx = this.indices.get(i);
            ++currIdx;

            final boolean isBetweenDimension = (i + 1) < this.statespace.getNumberOfDimensions();
            // in the case of a completely traversal between dimension reset this dimension and
            // traversal next dimension otherwise complete traversal in this dimension and return
            if (currIdx == this.statespace.getSizeOfDimension(i) && isBetweenDimension) {
                this.indices.set(i, 0);
            } else {
                this.indices.set(i, currIdx);
                break;
            }
        }
    }

    @Override
    public void patchModels(final Map<String, List<EObject>> models) {
        if (!this.hasNext()) {
            return;
        }

        // patches each dimension separately
        for (int i = 0; i < this.indices.size(); ++i) {
            this.statespace.patchModelsWith(models, i, this.indices.get(i));
        }
    }

    private final Statespace statespace;
    private final List<Integer> indices;

    @Override
    public List<String> getCurrentState() {
        final var res = this.indices.stream()
            .map(it -> String.valueOf(it))
            .collect(Collectors.toList());
        return res;
    }
}
