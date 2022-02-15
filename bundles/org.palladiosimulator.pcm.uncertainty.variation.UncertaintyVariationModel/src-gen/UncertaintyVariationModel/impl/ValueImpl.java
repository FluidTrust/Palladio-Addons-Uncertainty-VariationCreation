/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.Value;
import UncertaintyVariationModel.VariationDescription;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.ValueImpl#getVariationdescription <em>Variationdescription</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ValueImpl extends MinimalEObjectImpl.Container implements Value
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl()
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
		return UncertaintyVariationModelPackage.Literals.VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationDescription getVariationdescription()
	{
		if (eContainerFeatureID() != UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION) return null;
		return (VariationDescription)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariationdescription(VariationDescription newVariationdescription, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newVariationdescription, UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationdescription(VariationDescription newVariationdescription)
	{
		if (newVariationdescription != eInternalContainer() || (eContainerFeatureID() != UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION && newVariationdescription != null))
		{
			if (EcoreUtil.isAncestor(this, newVariationdescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVariationdescription != null)
				msgs = ((InternalEObject)newVariationdescription).eInverseAdd(this, UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS, VariationDescription.class, msgs);
			msgs = basicSetVariationdescription(newVariationdescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION, newVariationdescription, newVariationdescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVariationdescription((VariationDescription)otherEnd, msgs);
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				return basicSetVariationdescription(null, msgs);
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				return eInternalContainer().eInverseRemove(this, UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS, VariationDescription.class, msgs);
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				return getVariationdescription();
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				setVariationdescription((VariationDescription)newValue);
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				setVariationdescription((VariationDescription)null);
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
			case UncertaintyVariationModelPackage.VALUE__VARIATIONDESCRIPTION:
				return getVariationdescription() != null;
		}
		return super.eIsSet(featureID);
	}

} //ValueImpl
