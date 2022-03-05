package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ConcreteScenarioManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcmImpl;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test for the public api
 */
class UncertaintyVariationModelGenPcmTests {
    private static final String VALID_URI_TEST_MODEL = "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/allocation_test.uncertaintyvariationmodel";
    private static final String LOGGER_NAME = "org.palladiosimulator.pcm.uncertainty.variation.logger";

    @BeforeAll
    static void initAll() {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        try {
            IProgressMonitor mon = new NullProgressMonitor();
            IProject pro = workspace.getRoot()
                .getProject("TestResults");
            pro.create(mon);
            pro.open(mon);

        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    @Test()
    void testNullUriFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UncertaintyVariationModelGenPcm(null);
        });
    }

    @Test()
    void testNotPlatformUriFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            final URI uri = URI.createURI("xxx");
            new UncertaintyVariationModelGenPcm(uri);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final URI uri = URI.createURI("platform:/resource");
            new UncertaintyVariationModelGenPcm(uri);
        });
    }

    @Test()
    void testInvalidExtensionUriFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            final URI uri = URI.createURI("platform:/resource/model.test");
            new UncertaintyVariationModelGenPcm(uri);
        });
    }

    @Test()
    void testValidUri() {
        final var sourceDirName = "source";
        final Logger logger = LoggerFactory.getLogger(LOGGER_NAME);

        final URI uri = URI.createURI(VALID_URI_TEST_MODEL);

        assertDoesNotThrow(() -> VariationManager.validate(uri, logger));
        final var resourceAbstraction = new ModelResourceAbstraction();
        final var variationManager = new VariationManager(uri, resourceAbstraction);
        final var scenarioManager = assertDoesNotThrow(
                () -> new ConcreteScenarioManager(uri.trimSegments(1), sourceDirName,
                        URI.createURI("platform:/resource/TestResults/gen_pcm_test"), "var", resourceAbstraction));
        final var generator = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        // generator.generateVariations(new NullProgressMonitor());

        // run generator again to cover path were folders were already created
        final var generator2 = new UncertaintyVariationModelGenPcmImpl(scenarioManager, variationManager, logger);
        // generator2.generateVariations(new NullProgressMonitor());
    }

    @AfterAll
    static void cleanupAll() {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        try {
            IProgressMonitor mon = new NullProgressMonitor();
            IProject pro = workspace.getRoot()
                .getProject("TestResults");
            pro.close(mon);
            pro.delete(true, mon);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    };

}
