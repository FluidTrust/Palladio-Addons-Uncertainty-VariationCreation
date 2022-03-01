package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;

/**
 * Test for the public api
 */
class UncertaintyVariationModelGenPcmTests {
    @BeforeAll
    static void initAll() {
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
        // throws when trying to create the result folder
        // reason: platform:/plugin is read-only
        assertThrows(CoreException.class, () -> {
            final URI uri = URI.createURI(
                    "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/model.uncertaintyvariationmodel");
            new UncertaintyVariationModelGenPcm(uri);
        });
    }

    @AfterAll
    static void cleanupAll() {
    };

}
