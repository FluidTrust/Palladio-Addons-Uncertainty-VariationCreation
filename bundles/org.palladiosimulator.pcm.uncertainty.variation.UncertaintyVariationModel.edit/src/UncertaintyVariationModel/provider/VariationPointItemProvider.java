package UncertaintyVariationModel.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.statehandler.util.StateHandlerImplementation;
import de.uka.ipd.sdq.identifier.Identifier;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ItemPropertyDescriptorUtils;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class VariationPointItemProvider extends VariationPointItemProviderGen {

    public VariationPointItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    protected void addStateHandlerIdPropertyDescriptor(final Object object) {
        super.addStateHandlerIdPropertyDescriptor(object);

        final var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(this.itemPropertyDescriptors);

        decorator.setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(VariationPoint.class, String.class) {
            @Override
            protected Collection<?> getValueChoiceTyped(final VariationPoint object, final List<String> typedList) {
                final StateHandlerImplementation impl = new StateHandlerImplementation();
                final var stateHandlerId = object.getStateHandlerId();
                if (stateHandlerId == null) {
                    return impl.getIds();
                }

                final List<String> ids = impl.getIds();
                ids.add(null);

                return ids;
            }
        });
    }

    @Override
    protected void addVaryingSubjectsPropertyDescriptor(final Object object) {
        super.addVaryingSubjectsPropertyDescriptor(object);

        final var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(this.itemPropertyDescriptors);

        decorator.setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(VariationPoint.class, Identifier.class) {
            @Override
            protected Collection<?> getValueChoiceTyped(final VariationPoint object, List<Identifier> typedList) {
                final var impl = new StateHandlerImplementation();
                final var stateHandlerId = object.getStateHandlerId();
                if (stateHandlerId == null) {
                    return typedList;
                }

                typedList = typedList.stream()
                    .filter(it -> impl.isAccecptedSubjectByImplementation(stateHandlerId, it))
                    .collect(Collectors.toList());
                return typedList;
            }
        });
    }

}
