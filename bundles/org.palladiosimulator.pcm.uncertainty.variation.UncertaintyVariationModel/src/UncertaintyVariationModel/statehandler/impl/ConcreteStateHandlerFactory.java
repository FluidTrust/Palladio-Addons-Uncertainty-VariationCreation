package UncertaintyVariationModel.statehandler.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.StateHandler;
import UncertaintyVariationModel.statehandler.StateHandlerFactory;

public class ConcreteStateHandlerFactory implements StateHandlerFactory {
    public ConcreteStateHandlerFactory() {
    }

    public static StateHandlerFactory init() {
        return new ConcreteStateHandlerFactory();
    }

    @Override
    public StateHandler createFor(final VariationPoint object) {
        String stateHandlerId = object.getStateHandlerId();
        IConfigurationElement[] config = Platform.getExtensionRegistry()
            .getConfigurationElementsFor(STATEHANDLER_IMPLEMENTATION_ID);
        try {
            for (IConfigurationElement element : config) {

                if (stateHandlerId.equalsIgnoreCase(element.getAttribute(ID_ATTRIBUTE))) {
                    System.out.println("Extention with name: " + element.getAttribute(NAME_ATTRIBUTE));
                    final StateHandler hnd = (StateHandler) element.createExecutableExtension(CLASS_ATTRIBUTE);
                    return hnd;
                }
            }
        } catch (CoreException ex) {
            System.out.println(ex.getStackTrace());
        }
        throw new UnsupportedOperationException("Unknown stateHandlerId " + stateHandlerId);
    }

    private static final String STATEHANDLER_IMPLEMENTATION_ID = "org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.statehandler_implementation";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String ID_ATTRIBUTE = "id";
}
