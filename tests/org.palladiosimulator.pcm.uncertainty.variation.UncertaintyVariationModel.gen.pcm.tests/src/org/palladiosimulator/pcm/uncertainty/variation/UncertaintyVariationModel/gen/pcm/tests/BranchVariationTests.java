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
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests.moc.DummyScenarioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BranchVariationTests {

    private static final String LOGGER_NAME = "org.palladiosimulator.pcm.uncertainty.variation.logger";
    private static final String BRANCH_UNCERTAINTY_MODEL_TEST_MODEL = "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/branch_test.uncertaintyvariationmodel";

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
                BRANCH_UNCERTAINTY_MODEL_TEST_MODEL);
        final var resourceAbstraction = new ModelResourceAbstraction();
        final var variationManager = new VariationManager(uri, resourceAbstraction);
        final List<URI> content = new ArrayList<>();
        content.add(URI.createFileURI("portSystem.repository"));
        content.add(URI.createFileURI("portUsageModel.usagemodel"));

        final var scenarioManager = new DummyScenarioManager(uri.trimSegments(1), sourceDirName, content);
        final Logger logger = LoggerFactory.getLogger(LOGGER_NAME);

        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        generator.generateVariations(new NullProgressMonitor());

        final List<Map<String, List<EObject>>> results = scenarioManager.getResults();
        assertEquals(4, results.size());
    }

}
