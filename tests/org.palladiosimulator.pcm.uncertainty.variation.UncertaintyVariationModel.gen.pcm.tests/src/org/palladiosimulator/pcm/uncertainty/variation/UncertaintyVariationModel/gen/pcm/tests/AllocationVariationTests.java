package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcmImpl;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests.moc.DummyScenarioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariations;
import de.uka.ipd.sdq.identifier.Identifier;

class AllocationVariationTests {
    private static final String LOGGER_NAME = "org.palladiosimulator.pcm.uncertainty.variation.logger";
    private static final String ALLOCATION_UNCERTAINTY_MODEL_TEST_MODEL = "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/allocation_test.uncertaintyvariationmodel";

    @BeforeAll
    static void initAll() {
    }

    @Test
    void testAllocationUncertaintyVariationModel() {
        final var sourceDirName = "source";

        final URI uri = URI.createURI(ALLOCATION_UNCERTAINTY_MODEL_TEST_MODEL);
        final var resourceAbstraction = new ModelResourceAbstraction();
        final var variationManager = new VariationManager(uri, resourceAbstraction);
        final List<URI> content = new ArrayList<>();
        content.add(URI.createFileURI("portAllocation.allocation"));
        content.add(URI.createFileURI("portHardware.resourceenvironment"));

        final var scenarioManager = new DummyScenarioManager(uri.trimSegments(1), sourceDirName, content);
        final Logger logger = LoggerFactory.getLogger(LOGGER_NAME);

        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        generator.generateVariations(new NullProgressMonitor());

        final List<Map<String, List<EObject>>> results = scenarioManager.getResults();
        assertEquals(4, results.size());

        final var uncertaintyVariationModel = (UncertaintyVariations) variationManager.loadUncertaintyVariantModel();
        // var 0 1
        // point 0: a b
        // point 1: c d
        // => ac, bc, ad, bd
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 0, 0)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 0, 0)
                    .getId());
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 0, 1)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 0, 1)
                    .getId());
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 1, 0)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 1, 0)
                    .getId());
        assertEquals(this.extractVariationLink(uncertaintyVariationModel, 1, 1)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 1, 3)
                    .getId());
    }

    private Identifier extractAllocationResult(final List<Map<String, List<EObject>>> results,
            final UncertaintyVariations uncertaintyVarationModel, final int varPoint, final int resultIdx) {
        final var currSubject = uncertaintyVarationModel.getVariationPoints()
            .get(varPoint)
            .getVaryingSubjects()
            .get(0);

        final var currAllocation = (Allocation) results.get(resultIdx)
            .get("allocation")
            .get(0);
        final var resolvedSubject = currAllocation.getAllocationContexts_Allocation()
            .stream()
            .filter(it -> it.getId()
                .equalsIgnoreCase(currSubject.getId()))
            .findAny();
        assertTrue(resolvedSubject.isPresent());
        final var x = resolvedSubject.orElse(null);
        return x.getResourceContainer_AllocationContext();
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

    @AfterAll
    static void cleanupAll() {
    };
}
