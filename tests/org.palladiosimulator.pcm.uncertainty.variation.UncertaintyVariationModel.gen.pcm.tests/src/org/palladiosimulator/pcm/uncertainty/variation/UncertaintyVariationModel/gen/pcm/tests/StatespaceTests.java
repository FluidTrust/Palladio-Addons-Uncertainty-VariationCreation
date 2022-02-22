package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;

class StatespaceTests {
    @BeforeAll
    static void initAll() {
    }

    @Test
    void testEmptyUncertaintyVariationModel() {
        final URI uri = URI.createURI(
                "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/empty.uncertaintyvariationmodel");
        final var variationManager = new VariationManager(uri);
        final var statespace = new Statespace(variationManager.loadUncertaintyVariantModel());
        final var it = statespace.iterator();
        assertEquals(0, statespace.getNumberOfDimensions());
        assertFalse(it.hasNext());
        assertThrows(IllegalArgumentException.class, () -> {
            statespace.getSizeOfDimension(0);
        });

        assertTrue(statespace.getDimensions()
            .isEmpty());
        assertTrue(it.getCurrentState()
            .isEmpty());

        for (final var it2 = statespace.iterator(); it2.hasNext(); it2.next()) {
            fail("this should never be reached");
        }
    }

    @Test
    void testInvalidUncertaintyVariationModel() {
        final URI uri = URI.createURI(
                "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/invalid.uncertaintyvariationmodel");
        final var variationManager = new VariationManager(uri);
        assertThrows(IllegalStateException.class, () -> {
            new Statespace(variationManager.loadUncertaintyVariantModel());
        });
    }

    @AfterAll
    static void cleanupAll() {
    };
}
