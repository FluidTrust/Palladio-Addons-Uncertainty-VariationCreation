package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcmImpl;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariations;
import de.uka.ipd.sdq.identifier.Identifier;

class AssemblyVarationTests {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testAssemblyUncertaintyVariationModel() {
        final var sourceDirName = "source";

        final URI uri = URI.createURI(
                "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/assembly_test.uncertaintyvariationmodel");
        final var variationManager = new VariationManager(uri);
        final List<URI> content = new ArrayList<>();
        content.add(URI.createFileURI("portSystem.repository"));
        content.add(URI.createFileURI("portSystem2.repository"));
        content.add(URI.createFileURI("portSystem.system"));

        final var scenarioManager = new DummyScenarioManager(uri.trimSegments(1), sourceDirName, content);
        final Logger logger = LoggerFactory.getLogger("org.palladiosimulator.pcm.uncertainty.variation.logger");

        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        generator.generateVariations(new NullProgressMonitor());

        final List<Map<String, List<EObject>>> results = scenarioManager.getResults();
        assertEquals(2, results.size());

        final var uncertaintyVariationModel = (UncertaintyVariations) variationManager.loadUncertaintyVariantModel();
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 0, 0)
            .getId(),
                this.extractSystemResult(results, uncertaintyVariationModel, 0, 0)
                    .getId());
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 0, 1)
            .getId(),
                this.extractSystemResult(results, uncertaintyVariationModel, 0, 1)
                    .getId());
    }

    private Identifier extractSystemResult(final List<Map<String, List<EObject>>> results,
            final UncertaintyVariations uncertaintyVarationModel, final int varPoint, final int resultIdx) {
        final var currSubject = uncertaintyVarationModel.getVariationPoints()
            .get(varPoint)
            .getVaryingSubjects()
            .get(0);

        final var sys = (System) results.get(resultIdx)
            .get("system")
            .get(0);

        final var resolvedSubject = sys.getAssemblyContexts__ComposedStructure()
            .stream()
            .filter(it -> it.getId()
                .equalsIgnoreCase(currSubject.getId()))
            .findAny();
        assertTrue(resolvedSubject.isPresent());
        final var x = resolvedSubject.orElse(null);
        return x.getEncapsulatedComponent__AssemblyContext();
    }

    private Identifier extractVariationLink(final UncertaintyVariations uncertaintyVarationModel,
            final Integer varPoint, final Integer varIdx) {
        final var currValue = (PrimitiveValue) (uncertaintyVarationModel.getVariationPoints()
            .get(varPoint)
            .getVariationDescription()
            .getTargetVariations()
            .get(varIdx));
        final var currLink = currValue.getLink();
        return currLink;
    }

}
