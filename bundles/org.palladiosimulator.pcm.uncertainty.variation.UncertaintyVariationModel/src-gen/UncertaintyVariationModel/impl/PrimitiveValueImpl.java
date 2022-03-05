/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariationModelPackage;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.PrimitiveValueImpl#getLink <em>Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveValueImpl extends ValueImpl implements PrimitiveValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveValueImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return UncertaintyVariationModelPackage.Literals.PRIMITIVE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getLink()
	{
		return (Identifier)eDynamicGet(UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK, UncertaintyVariationModelPackage.Literals.PRIMITIVE_VALUE__LINK, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetLink()
	{
		return (Identifier)eDynamicGet(UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK, UncertaintyVariationModelPackage.Literals.PRIMITIVE_VALUE__LINK, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(Identifier newLink)
	{
		eDynamicSet(UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK, UncertaintyVariationModelPackage.Literals.PRIMITIVE_VALUE__LINK, newLink);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK:
				if (resolve) return getLink();
				return basicGetLink();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK:
				setLink((Identifier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK:
				setLink((Identifier)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK:
				return basicGetLink() != null;
		}
		return super.eIsSet(featureID);
	}

} //PrimitiveValueImpl
