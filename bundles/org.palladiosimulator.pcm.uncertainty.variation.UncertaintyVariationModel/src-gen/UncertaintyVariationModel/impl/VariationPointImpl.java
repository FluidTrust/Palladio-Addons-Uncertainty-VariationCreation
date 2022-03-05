/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.VariationPointImpl#getVaryingSubjects <em>Varying Subjects</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VariationPointImpl#getVariationDescription <em>Variation Description</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VariationPointImpl#getStateHandlerId <em>State Handler Id</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VariationPointImpl#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariationPointImpl extends CDOObjectImpl implements VariationPoint
{
	/**
	 * The default value of the '{@link #getStateHandlerId() <em>State Handler Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateHandlerId()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_HANDLER_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariationPointImpl()
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
		return UncertaintyVariationModelPackage.Literals.VARIATION_POINT;
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
	public EList<Identifier> getVaryingSubjects()
	{
		return (EList<Identifier>)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__VARYING_SUBJECTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationDescription getVariationDescription()
	{
		return (VariationDescription)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__VARIATION_DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariationDescription(VariationDescription newVariationDescription, NotificationChain msgs)
	{
		msgs = eDynamicInverseAdd((InternalEObject)newVariationDescription, UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationDescription(VariationDescription newVariationDescription)
	{
		eDynamicSet(UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__VARIATION_DESCRIPTION, newVariationDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStateHandlerId()
	{
		return (String)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__STATE_HANDLER_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateHandlerId(String newStateHandlerId)
	{
		eDynamicSet(UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__STATE_HANDLER_ID, newStateHandlerId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntityName()
	{
		return (String)eDynamicGet(UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__ENTITY_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntityName(String newEntityName)
	{
		eDynamicSet(UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME, UncertaintyVariationModelPackage.Literals.VARIATION_POINT__ENTITY_NAME, newEntityName);
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				VariationDescription variationDescription = getVariationDescription();
				if (variationDescription != null)
					msgs = ((InternalEObject)variationDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, null, msgs);
				return basicSetVariationDescription((VariationDescription)otherEnd, msgs);
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				return basicSetVariationDescription(null, msgs);
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
				return getVaryingSubjects();
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				return getVariationDescription();
			case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
				return getStateHandlerId();
			case UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME:
				return getEntityName();
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
				getVaryingSubjects().clear();
				getVaryingSubjects().addAll((Collection<? extends Identifier>)newValue);
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				setVariationDescription((VariationDescription)newValue);
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
				setStateHandlerId((String)newValue);
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME:
				setEntityName((String)newValue);
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
				getVaryingSubjects().clear();
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				setVariationDescription((VariationDescription)null);
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
				setStateHandlerId(STATE_HANDLER_ID_EDEFAULT);
				return;
			case UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME:
				setEntityName(ENTITY_NAME_EDEFAULT);
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
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
				return !getVaryingSubjects().isEmpty();
			case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
				return getVariationDescription() != null;
			case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
				return STATE_HANDLER_ID_EDEFAULT == null ? getStateHandlerId() != null : !STATE_HANDLER_ID_EDEFAULT.equals(getStateHandlerId());
			case UncertaintyVariationModelPackage.VARIATION_POINT__ENTITY_NAME:
				return ENTITY_NAME_EDEFAULT == null ? getEntityName() != null : !ENTITY_NAME_EDEFAULT.equals(getEntityName());
		}
		return super.eIsSet(featureID);
	}

} //VariationPointImpl
