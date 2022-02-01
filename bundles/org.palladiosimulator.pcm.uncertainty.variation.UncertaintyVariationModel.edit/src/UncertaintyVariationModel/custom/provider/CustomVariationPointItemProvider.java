package UncertaintyVariationModel.custom.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;

import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.provider.VariationPointItemProvider;
import UncertaintyVariationModel.statehandler.util.StateHandlerImplementation;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ItemPropertyDescriptorUtils;
import tools.mdsd.library.emfeditutils.itempropertydescriptor.ValueChoiceCalculatorBase;

public class CustomVariationPointItemProvider extends VariationPointItemProvider {

    public CustomVariationPointItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    protected void addStateHandlerIdPropertyDescriptor(Object object) {
        super.addStateHandlerIdPropertyDescriptor(object);

        var decorator = ItemPropertyDescriptorUtils.decorateLastDescriptor(this.itemPropertyDescriptors);

        decorator.setValueChoiceCalculator(new ValueChoiceCalculatorBase<>(VariationPoint.class, String.class) {
            @Override
            protected Collection<?> getValueChoiceTyped(VariationPoint object, List<String> typedList) {
                StateHandlerImplementation impl = new StateHandlerImplementation();
                return impl.getIds();
            }
        });
    }

}
