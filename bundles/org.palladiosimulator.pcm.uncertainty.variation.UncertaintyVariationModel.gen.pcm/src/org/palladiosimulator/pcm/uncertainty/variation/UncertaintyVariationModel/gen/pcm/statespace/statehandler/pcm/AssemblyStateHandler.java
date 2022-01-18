package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.core.composition.RequiredDelegationConnector;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;
import de.uka.ipd.sdq.identifier.Identifier;

public class AssemblyStateHandler extends GenericStateHandler {

    @Override
    public int getSizeOfDimension(final VariationPoint variationPoint) {
        final VariationDescription desc = variationPoint.getVariationDescription();
        return desc.getTargetVariations()
            .size();
    }

    @Override
    public void patchModelWith(final Map<String, List<EObject>> models, final VariationPoint variationPoint,
            final int variationIdx) {
        final VariationDescription desc = variationPoint.getVariationDescription();
        for (final String modelType : getModelTypes()) {
            for (final EObject container : models.get(modelType)) {
                for (final Identifier curr : variationPoint.getVaryingSubjects()) {
                    final Optional<EObject> resolvedVariation = this.resolve(models.get(MODEL_TYPE2),
                            desc.getTargetVariations()
                                .get(variationIdx));
                    final Optional<EObject> resolvedSubject = this.resolve(container, curr);
                    resolvedSubject.ifPresent(subject -> this.patch(subject, resolvedVariation));
                }
            }
        }
    }

    public static List<String> getModelTypes() {
        return Arrays.asList(MODEL_TYPE1, MODEL_TYPE2);
    }

    private static final String MODEL_TYPE1 = "system";
    private static final String MODEL_TYPE2 = "repository";

    private void patch(final EObject subject, final Optional<EObject> value) {
        value.ifPresent(val -> {
            final AssemblyContext resolved = (AssemblyContext) subject;
            final RepositoryComponent variantComponent = (RepositoryComponent) val;
            final RepositoryComponent currentComponent = resolved.getEncapsulatedComponent__AssemblyContext();

            patchProvidedConnectors(resolved, variantComponent, currentComponent);
            patchRequiredConnectors(resolved, variantComponent, currentComponent);

            resolved.setEncapsulatedComponent__AssemblyContext(variantComponent);
        });
    }

    private void patchRequiredConnectors(final AssemblyContext resolved, final RepositoryComponent variantComponent,
            final RepositoryComponent currentComponent) {
        for (int i = 0; i < currentComponent.getRequiredRoles_InterfaceRequiringEntity()
            .size(); ++i) {
            final int idx = i;
            final OperationRequiredRole variantRole = (OperationRequiredRole) variantComponent
                .getRequiredRoles_InterfaceRequiringEntity()
                .get(idx);
            final OperationRequiredRole currentRole = (OperationRequiredRole) currentComponent
                .getRequiredRoles_InterfaceRequiringEntity()
                .get(idx);
            // get Assembly connector
            Optional<AssemblyConnector> connector = this.findInstance(resolved.eContainer(),
                    currObj -> currObj instanceof AssemblyConnector,
                    curr -> curr.getRequiringAssemblyContext_AssemblyConnector()
                        .equals(resolved)
                            && curr.getRequiredRole_AssemblyConnector()
                                .equals(currentRole));
            connector.ifPresent(val -> val.setRequiredRole_AssemblyConnector(variantRole));
            // get Delegation connector
            Optional<RequiredDelegationConnector> connector2 = this.findInstance(resolved.eContainer(),
                    currObj -> currObj instanceof RequiredDelegationConnector,
                    curr -> curr.getAssemblyContext_RequiredDelegationConnector()
                        .equals(resolved)
                            && curr.getInnerRequiredRole_RequiredDelegationConnector()
                                .equals(currentRole));
            connector2.ifPresent(val -> val.setInnerRequiredRole_RequiredDelegationConnector(variantRole));

        }
    }

    private void patchProvidedConnectors(final AssemblyContext resolved, final RepositoryComponent variantComponent,
            final RepositoryComponent currentComponent) {
        for (int i = 0; i < currentComponent.getProvidedRoles_InterfaceProvidingEntity()
            .size(); ++i) {
            final int idx = i;
            final OperationProvidedRole variantRole = (OperationProvidedRole) variantComponent
                .getProvidedRoles_InterfaceProvidingEntity()
                .get(idx);
            final OperationProvidedRole currentRole = (OperationProvidedRole) currentComponent
                .getProvidedRoles_InterfaceProvidingEntity()
                .get(idx);

            // get Assembly Connector
            Optional<AssemblyConnector> connector = this.findInstance(resolved.eContainer(),
                    currObj -> currObj instanceof AssemblyConnector,
                    curr -> curr.getProvidingAssemblyContext_AssemblyConnector()
                        .equals(resolved)
                            && curr.getProvidedRole_AssemblyConnector()
                                .equals(currentRole));
            connector.ifPresent(val -> val.setProvidedRole_AssemblyConnector(variantRole));
            // get Delegation connector

            Optional<ProvidedDelegationConnector> connector2 = this.findInstance(resolved.eContainer(),
                    currObj -> currObj instanceof ProvidedDelegationConnector,
                    curr -> curr.getAssemblyContext_ProvidedDelegationConnector()
                        .equals(resolved)
                            && curr.getInnerProvidedRole_ProvidedDelegationConnector()
                                .equals(currentRole));

            connector2.ifPresent(val -> val.setInnerProvidedRole_ProvidedDelegationConnector(variantRole));
        }
    }
}
