/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UncertaintyVariationModelFactoryImpl extends EFactoryImpl implements UncertaintyVariationModelFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UncertaintyVariationModelFactory init()
	{
		try
		{
			UncertaintyVariationModelFactory theUncertaintyVariationModelFactory = (UncertaintyVariationModelFactory)EPackage.Registry.INSTANCE.getEFactory(UncertaintyVariationModelPackage.eNS_URI);
			if (theUncertaintyVariationModelFactory != null)
			{
				return theUncertaintyVariationModelFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UncertaintyVariationModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS: return (EObject)createUncertaintyVariations();
			case UncertaintyVariationModelPackage.VARIATION_POINT: return (EObject)createVariationPoint();
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION: return (EObject)createVariationDescription();
			case UncertaintyVariationModelPackage.PRIMITIVE_VALUE: return (EObject)createPrimitiveValue();
			case UncertaintyVariationModelPackage.VALUE_COLLECTION: return (EObject)createValueCollection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariations createUncertaintyVariations()
	{
		UncertaintyVariationsImpl uncertaintyVariations = new UncertaintyVariationsImpl();
		return uncertaintyVariations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint createVariationPoint()
	{
		VariationPointImpl variationPoint = new VariationPointImpl();
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationDescription createVariationDescription()
	{
		VariationDescriptionImpl variationDescription = new VariationDescriptionImpl();
		return variationDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveValue createPrimitiveValue()
	{
		PrimitiveValueImpl primitiveValue = new PrimitiveValueImpl();
		return primitiveValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueCollection createValueCollection()
	{
		ValueCollectionImpl valueCollection = new ValueCollectionImpl();
		return valueCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelPackage getUncertaintyVariationModelPackage()
	{
		return (UncertaintyVariationModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UncertaintyVariationModelPackage getPackage()
	{
		return UncertaintyVariationModelPackage.eINSTANCE;
	}

} //UncertaintyVariationModelFactoryImpl
