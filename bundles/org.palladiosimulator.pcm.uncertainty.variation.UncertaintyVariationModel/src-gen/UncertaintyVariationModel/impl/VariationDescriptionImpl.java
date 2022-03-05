/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.Value;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.VariationDescriptionImpl#getTargetVariations <em>Target Variations</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VariationDescriptionImpl#getVariationpoint <em>Variationpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariationDescriptionImpl extends CDOObjectImpl implements VariationDescription
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationDescriptionImpl()
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
		return UncertaintyVariationModelPackage.Literals.VARIATION_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Value> getTargetVariations()
	{
		return (EList<Value>)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS, UncertaintyVariationModelPackage.Literals.VARIATION_DESCRIPTION__TARGET_VARIATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint getVariationpoint()
	{
		return (VariationPoint)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT, UncertaintyVariationModelPackage.Literals.VARIATION_DESCRIPTION__VARIATIONPOINT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariationpoint(VariationPoint newVariationpoint, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newVariationpoint, UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationpoint(VariationPoint newVariationpoint)
	{
		eDynamicSet(UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT, UncertaintyVariationModelPackage.Literals.VARIATION_DESCRIPTION__VARIATIONPOINT, newVariationpoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetVariations()).basicAdd(otherEnd, msgs);
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVariationpoint((VariationPoint)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				return ((InternalEList<?>)getTargetVariations()).basicRemove(otherEnd, msgs);
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				return basicSetVariationpoint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				return eInternalContainer().eInverseRemove(this, UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, VariationPoint.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				return getTargetVariations();
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				return getVariationpoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				getTargetVariations().clear();
				getTargetVariations().addAll((Collection<? extends Value>)newValue);
				return;
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				setVariationpoint((VariationPoint)newValue);
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
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				getTargetVariations().clear();
				return;
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				setVariationpoint((VariationPoint)null);
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
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
				return !getTargetVariations().isEmpty();
			case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__VARIATIONPOINT:
				return getVariationpoint() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariationDescriptionImpl
