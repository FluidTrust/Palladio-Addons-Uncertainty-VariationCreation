package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.dataflow.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcmImpl;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests.moc.DummyScenarioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CharacteristicsVariationsTests {
    private static final String LOGGER_NAME = "org.palladiosimulator.pcm.uncertainty.variation.logger";
    private static final String CHARACTERISTICS_UNCERTAINTY_MODEL_TEST_MODEL = "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.dataflow.tests/tmp/characteristics_test.uncertaintyvariationmodel";

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test
    void testCharacteristicsUncertaintyVariationModel() {
        final var sourceDirName = "source";

        final var uri = URI.createURI(CHARACTERISTICS_UNCERTAINTY_MODEL_TEST_MODEL);
        final var resourceAbstraction = new ModelResourceAbstraction();
        final var variationManager = new VariationManager(uri, resourceAbstraction);
        final List<URI> content = new ArrayList<>();
        content.add(URI.createFileURI("portUsageModel.usagemodel.characteristics"));
        content.add(URI.createFileURI("pcs.pddc"));

        final var scenarioManager = new DummyScenarioManager(uri.trimSegments(1), sourceDirName, content);
        final Logger logger = LoggerFactory.getLogger(LOGGER_NAME);
        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        // pcs.pddc parsing creates error: lineNumber: 1; columnNumber: 1; Content ist nicht
        // zulässig in Prolog

        // generator.generateVariations(new NullProgressMonitor());
    }

}
