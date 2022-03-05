package UncertaintyVariationModel.statehandler.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import UncertaintyVariationModel.statehandler.StateHandler;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * StateHandlerImplementation realizes the access to and queries on the StateHandler Implementation
 * extension point.
 *
 */
public class StateHandlerImplementation {
    /**
     * Constructor
     */
    public StateHandlerImplementation() {
    }

    /**
     * creates and returns an optional implementation corresponding to a given id.
     *
     * @param stateHandlerId
     *            the id of the implementation
     * @return the created optional implementation of the StateHandler
     */
    public Optional<StateHandler> getImplemationOf(final String stateHandlerId) {
        return this.getConfigurationElements()
            .filter(it -> stateHandlerId.contentEquals(this.getIdOf(it)))
            .map(it -> this.getImplementationOf(it))
            .filter(it -> it != null)
            .findFirst();
    }

    /**
     * returns all known ids.
     *
     * @return list of ids corresponding to the StateHandler implementations
     */
    public List<String> getIds() {
        return this.getConfigurationElements()
            .map(elem -> this.getIdOf(elem))
            .collect(Collectors.toList());
    }

    /**
     * returns the decision whether or not a subject is accepted by the current implementation.
     *
     * @param stateHandlerId
     *            the id of the current implementation
     * @param subject
     *            the current subject
     * @return true if the subject is accepted and false otherwise
     */
    public boolean isAccecptedSubjectByImplementation(final String stateHandlerId, final Identifier subject) {
        final var result = this.getConfigurationElements()
            .filter(it -> stateHandlerId.contentEquals(this.getIdOf(it)))
            .map(it -> this.getTypesInDefinition(it, VARYING_SUBJECT_DEFINTION_TYPE))
            .anyMatch(subTypeNames -> implementsAnyInterface(subject, subTypeNames));
        return result;
    }

    /**
     * returns the decision whether or not a link is accepted by the current implementation.
     *
     * @param stateHandlerId
     *            the id of the current implementation
     * @param link
     *            the current link
     * @return true if the link is accepted and false otherwise
     */
    public boolean isAcceptedLinkByImplementation(final String stateHandlerId, final Identifier link) {
        final var result = this.getConfigurationElements()
            .filter(it -> stateHandlerId.contentEquals(this.getIdOf(it)))
            .map(it -> this.getTypesInDefinition(it, VARIATION_DESCRIPTION_DEFINITION_TYPE))
            .anyMatch(linkTypeNames -> implementsAnyInterface(link, linkTypeNames));
        return result;
    }

    private boolean implementsAnyInterface(final Identifier element, Stream<String> interfaceNames) {
        return interfaceNames.anyMatch(typeName -> Arrays.stream(element.getClass()
            .getInterfaces())
            .filter(it -> it != null)
            .anyMatch(it -> it.getName()
                .contentEquals(typeName)));
    }

    private Stream<String> getTypesInDefinition(final IConfigurationElement elem, final String definitionName) {
        final Optional<IConfigurationElement> definition = Arrays.stream(elem.getChildren(definitionName))
            .findFirst();
        Stream<String> result = Stream.empty();
        if (definition.isPresent()) {
            final IConfigurationElement[] typesDefinition = definition.orElse(null)
                .getChildren();
            result = Arrays.stream(typesDefinition)
                .map(it -> this.getTypeOf(it));
        }
        return result;
    }

    private String getIdOf(final IConfigurationElement elem) {
        return elem.getAttribute(ID_ATTRIBUTE);
    }

    private StateHandler getImplementationOf(final IConfigurationElement elem) {
        try {
            return (StateHandler) elem.createExecutableExtension(CLASS_ATTRIBUTE);
        } catch (final CoreException e) {
            LOGGER.error("cannot instanciate specifyied class", e);
        }
        return null;
    }

    private String getTypeOf(final IConfigurationElement elem) {
        return elem.getAttribute(TYPE_ATTRIBUTE);
    }

    private Stream<IConfigurationElement> getConfigurationElements() {
        return Arrays.stream(Platform.getExtensionRegistry()
            .getConfigurationElementsFor(STATEHANDLER_IMPLEMENTATION_ID));
    }

    private static final String STATEHANDLER_IMPLEMENTATION_ID = "org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.statehandler_implementation";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String ID_ATTRIBUTE = "id";
    private static final String VARYING_SUBJECT_DEFINTION_TYPE = "VaryingSubjectDefinition";
    private static final String VARIATION_DESCRIPTION_DEFINITION_TYPE = "VariationDescriptionDefinition";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final Logger LOGGER = LoggerFactory
        .getLogger("org.palladiosimulator.pcm.uncertainty.variation.logger");

}
