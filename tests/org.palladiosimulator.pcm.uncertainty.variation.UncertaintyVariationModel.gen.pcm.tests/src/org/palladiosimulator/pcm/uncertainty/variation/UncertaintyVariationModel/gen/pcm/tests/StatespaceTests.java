package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.VariationManager;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ModelResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.adapter.resource.ResourceAbstraction;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.StatespaceIterator;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariations;
import de.uka.ipd.sdq.identifier.Identifier;

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

        for (final var it2 = statespace.iterator(); it2.hasNext(); it2.next()) {
            fail("this should never be reached");
        }
    }

    @Test
    void testAllocationUncertaintyVariationModel() {
        final var sourceDirName = "source";

        final URI uri = URI.createURI(
                "platform:/plugin/org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.tests/tmp/allocation_test.uncertaintyvariationmodel");
        final var variationManager = new VariationManager(uri);

        final Supplier<Map<String, List<EObject>>> modelLoader = () -> {
            final ResourceAbstraction res = new ModelResourceAbstraction(Arrays.asList("allocation"));
            final var model = res.load(uri.trimSegments(1)
                .appendSegment(sourceDirName)
                .appendSegment("portAllocation.allocation"));

            final Map<String, List<EObject>> models = new HashMap<>();
            models.put("allocation", Arrays.asList(model));

            return models;
        };

        final var model = variationManager.loadUncertaintyVariantModel();
        final var statespace = new Statespace(model);
        assertEquals(2, statespace.getNumberOfDimensions());
        assertEquals(2, statespace.getSizeOfDimension(0));
        assertEquals(2, statespace.getSizeOfDimension(1));

        int i = 0;
        final List<Map<String, List<EObject>>> results = new ArrayList<>();
        for (final StatespaceIterator it = statespace.iterator(); it.hasNext(); it.next()) {
            final Map<String, List<EObject>> models = assertDoesNotThrow(() -> {
                return modelLoader.get();
            });
            // loaded models exists
            assertEquals(1, models.size());
            assertEquals(1, models.get("allocation")
                .size());
            assertNotNull(models.get("allocation")
                .get(0));
            it.patchModels(models);
            results.add(models);
            ++i;
        }

        assertEquals(4, i);
        assertEquals(4, results.size());

        final var uncertaintyVariationModel = (UncertaintyVariations) model;
        // var 0 1
        // point 0: a b
        // point 1: c d
        // => ac, bc, ad, bd
        assertEquals(this.extractAllocationVariationLink(uncertaintyVariationModel, 0, 0)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 0, 0)
                    .getId());
        assertEquals(this.extractAllocationVariationLink(uncertaintyVariationModel, 0, 1)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 0, 1)
                    .getId());
        assertEquals(this.extractAllocationVariationLink(uncertaintyVariationModel, 1, 0)
            .getId(),
                this.extractAllocationResult(results, uncertaintyVariationModel, 1, 0)
                    .getId());
        assertEquals(this.extractAllocationVariationLink(uncertaintyVariationModel, 1, 1)
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

    private Identifier extractAllocationVariationLink(final UncertaintyVariations uncertaintyVarationModel,
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
