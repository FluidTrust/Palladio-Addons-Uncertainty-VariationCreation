/**
 */
package UncertaintyVariationModel.util;

import UncertaintyVariationModel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage
 * @generated
 */
public class UncertaintyVariationModelAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UncertaintyVariationModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = UncertaintyVariationModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UncertaintyVariationModelSwitch<Adapter> modelSwitch =
		new UncertaintyVariationModelSwitch<Adapter>()
		{
			@Override
			public Adapter caseUncertaintyVariations(UncertaintyVariations object)
			{
				return createUncertaintyVariationsAdapter();
			}
			@Override
			public Adapter caseVariationPoint(VariationPoint object)
			{
				return createVariationPointAdapter();
			}
			@Override
			public Adapter caseVariationDescription(VariationDescription object)
			{
				return createVariationDescriptionAdapter();
			}
			@Override
			public Adapter caseValue(Value object)
			{
				return createValueAdapter();
			}
			@Override
			public Adapter casePrimitiveValue(PrimitiveValue object)
			{
				return createPrimitiveValueAdapter();
			}
			@Override
			public Adapter caseValueCollection(ValueCollection object)
			{
				return createValueCollectionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.UncertaintyVariations <em>Uncertainty Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.UncertaintyVariations
	 * @generated
	 */
	public Adapter createUncertaintyVariationsAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.VariationPoint
	 * @generated
	 */
	public Adapter createVariationPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.VariationDescription <em>Variation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.VariationDescription
	 * @generated
	 */
	public Adapter createVariationDescriptionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.Value
	 * @generated
	 */
	public Adapter createValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.PrimitiveValue <em>Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.PrimitiveValue
	 * @generated
	 */
	public Adapter createPrimitiveValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link UncertaintyVariationModel.ValueCollection <em>Value Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see UncertaintyVariationModel.ValueCollection
	 * @generated
	 */
	public Adapter createValueCollectionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //UncertaintyVariationModelAdapterFactory
