package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

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
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcmImpl;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BranchVariationTests {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testBranchUncertaintyVariationModel() {
        final var sourceDirName = "source";

        final URI uri = URI.createURI(
                "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/branch_test.uncertaintyvariationmodel");
        final var variationManager = new VariationManager(uri);
        final List<URI> content = new ArrayList<>();
        content.add(URI.createFileURI("portSystem.repository"));
        content.add(URI.createFileURI("portUsageModel.usagemodel"));

        final var scenarioManager = new DummyScenarioManager(uri.trimSegments(1), sourceDirName, content);
        Logger logger = LoggerFactory.getLogger("org.palladiosimulator.pcm.uncertainty.variation.logger");

        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        generator.generateVariations(new NullProgressMonitor());

        final List<Map<String, List<EObject>>> results = scenarioManager.getResults();
        assertEquals(4, results.size());
    }

}
