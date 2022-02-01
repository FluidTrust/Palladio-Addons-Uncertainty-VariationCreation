package UncertaintyVariationModel.statehandler.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import UncertaintyVariationModel.statehandler.StateHandler;

public class StateHandlerImplementation {
    public StateHandlerImplementation() {
        // TODO Auto-generated constructor stub
    }

    public Optional<StateHandler> getImplemationOf(final String stateHandlerId) {
        return getConfigurationElements().filter(elem -> stateHandlerId.contentEquals(getIdOf(elem)))
            .map(elem -> getImplementationOf(elem))
            .findFirst();
    }

    public List<String> getIds() {
        return getConfigurationElements().map(elem -> getIdOf(elem))
            .collect(Collectors.toList());
    }

    private String getIdOf(IConfigurationElement elem) {
        return elem.getAttribute(ID_ATTRIBUTE);
    }

    private StateHandler getImplementationOf(IConfigurationElement elem) {
        try {
            return (StateHandler) elem.createExecutableExtension(CLASS_ATTRIBUTE);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private Stream<IConfigurationElement> getConfigurationElements() {
        return Arrays.stream(Platform.getExtensionRegistry()
            .getConfigurationElementsFor(STATEHANDLER_IMPLEMENTATION_ID));
    }

    private static final String STATEHANDLER_IMPLEMENTATION_ID = "org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.statehandler_implementation";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String ID_ATTRIBUTE = "id";
}
