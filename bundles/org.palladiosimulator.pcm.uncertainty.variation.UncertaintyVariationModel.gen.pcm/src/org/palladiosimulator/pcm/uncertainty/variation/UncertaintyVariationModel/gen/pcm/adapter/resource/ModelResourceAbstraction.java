package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModelResourceAbstraction implements ResourceAbstraction {
    public ModelResourceAbstraction(final List<String> knownModelTypes) {
        updateRegisteredModels(knownModelTypes);
    }

    @Override
    public void updateRegisteredModels(final List<String> knownModelTypes) {
        final Registry reg = Registry.INSTANCE;
        final Map<String, Object> m = reg.getContentTypeToFactoryMap();
        for (final String model : knownModelTypes) {
            m.put(model, new XMIResourceFactoryImpl());
        }
    }

    @Override
    public EObject load(final URI modelUri) {
        final ResourceSet resSet = new ResourceSetImpl();
        final Resource res = resSet.getResource(modelUri, true);

        return res.getContents()
            .get(0);
    }

    @Override
    public void save(final EObject rootElement) throws IOException {
        final Resource res = rootElement.eResource();
        res.save(Collections.EMPTY_MAP);
    }
}
