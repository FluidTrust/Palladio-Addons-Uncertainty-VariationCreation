package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public interface StatespaceIterator {
    public boolean hasNext();

    public void next();

    public void patchModels(Map<String, List<EObject>> models);
}
