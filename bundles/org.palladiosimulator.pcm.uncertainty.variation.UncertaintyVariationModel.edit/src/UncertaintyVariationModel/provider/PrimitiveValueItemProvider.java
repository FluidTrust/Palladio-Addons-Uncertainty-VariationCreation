package UncertaintyVariationModel.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.statehandler.util.StateHandlerImplementation;
import de.uka.ipd.sdq.identifier.Identifier;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ItemPropertyDescriptorUtils;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class PrimitiveValueItemProvider extends PrimitiveValueItemProviderGen {
    public PrimitiveValueItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    protected void addLinkPropertyDescriptor(Object object) {
        super.addLinkPropertyDescriptor(object);

        final var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(this.itemPropertyDescriptors);

        decorator.setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(PrimitiveValue.class, Identifier.class) {
            @Override
            protected Collection<?> getValueChoiceTyped(final PrimitiveValue object, List<Identifier> typedList) {
                final var impl = new StateHandlerImplementation();
                final var stateHandlerId = object.getVariationdescription()
                    .getVariationpoint()
                    .getStateHandlerId();
                if (stateHandlerId.isEmpty()) {
                    return typedList;
                }

                typedList = typedList.stream()
                    .filter(it -> impl.isAcceptedLinkByImplementation(stateHandlerId, it))
                    .collect(Collectors.toList());
                return typedList;
            }
        });
    }

}
