/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.UncertaintyVariations;
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
 * An implementation of the model object '<em><b>Uncertainty Variations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.UncertaintyVariationsImpl#getVariationPoints <em>Variation Points</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UncertaintyVariationsImpl extends CDOObjectImpl implements UncertaintyVariations
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UncertaintyVariationsImpl()
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
		return UncertaintyVariationModelPackage.Literals.UNCERTAINTY_VARIATIONS;
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
	public EList<VariationPoint> getVariationPoints()
	{
		return (EList<VariationPoint>)eDynamicGet(UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS, UncertaintyVariationModelPackage.Literals.UNCERTAINTY_VARIATIONS__VARIATION_POINTS, true, true);
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
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS:
				return ((InternalEList<?>)getVariationPoints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS:
				return getVariationPoints();
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
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS:
				getVariationPoints().clear();
				getVariationPoints().addAll((Collection<? extends VariationPoint>)newValue);
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
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS:
				getVariationPoints().clear();
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
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS__VARIATION_POINTS:
				return !getVariationPoints().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UncertaintyVariationsImpl
