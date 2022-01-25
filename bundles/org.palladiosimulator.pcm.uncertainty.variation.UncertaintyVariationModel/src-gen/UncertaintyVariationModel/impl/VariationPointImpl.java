/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

import de.uka.ipd.sdq.identifier.Identifier;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
 * </ul>
 *
 * @generated
 */
public class VariationPointImpl extends MinimalEObjectImpl.Container implements VariationPoint {
	/**
     * The cached value of the '{@link #getVaryingSubjects() <em>Varying Subjects</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVaryingSubjects()
     * @generated
     * @ordered
     */
	protected EList<Identifier> varyingSubjects;

	/**
     * The cached value of the '{@link #getVariationDescription() <em>Variation Description</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariationDescription()
     * @generated
     * @ordered
     */
	protected VariationDescription variationDescription;

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
     * The cached value of the '{@link #getStateHandlerId() <em>State Handler Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStateHandlerId()
     * @generated
     * @ordered
     */
    protected String stateHandlerId = STATE_HANDLER_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected VariationPointImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return UncertaintyVariationModelPackage.Literals.VARIATION_POINT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Identifier> getVaryingSubjects() {
        if (varyingSubjects == null) {
            varyingSubjects = new EObjectResolvingEList<Identifier>(Identifier.class, this, UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS);
        }
        return varyingSubjects;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariationDescription getVariationDescription() {
        return variationDescription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetVariationDescription(VariationDescription newVariationDescription, NotificationChain msgs) {
        VariationDescription oldVariationDescription = variationDescription;
        variationDescription = newVariationDescription;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, oldVariationDescription, newVariationDescription);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariationDescription(VariationDescription newVariationDescription) {
        if (newVariationDescription != variationDescription) {
            NotificationChain msgs = null;
            if (variationDescription != null)
                msgs = ((InternalEObject)variationDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, null, msgs);
            if (newVariationDescription != null)
                msgs = ((InternalEObject)newVariationDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, null, msgs);
            msgs = basicSetVariationDescription(newVariationDescription, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION, newVariationDescription, newVariationDescription));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStateHandlerId() {
        return stateHandlerId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStateHandlerId(String newStateHandlerId) {
        String oldStateHandlerId = stateHandlerId;
        stateHandlerId = newStateHandlerId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID, oldStateHandlerId, stateHandlerId));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
                return getVaryingSubjects();
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
                return getVariationDescription();
            case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
                return getStateHandlerId();
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
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
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
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
                getVaryingSubjects().clear();
                return;
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
                setVariationDescription((VariationDescription)null);
                return;
            case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
                setStateHandlerId(STATE_HANDLER_ID_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARYING_SUBJECTS:
                return varyingSubjects != null && !varyingSubjects.isEmpty();
            case UncertaintyVariationModelPackage.VARIATION_POINT__VARIATION_DESCRIPTION:
                return variationDescription != null;
            case UncertaintyVariationModelPackage.VARIATION_POINT__STATE_HANDLER_ID:
                return STATE_HANDLER_ID_EDEFAULT == null ? stateHandlerId != null : !STATE_HANDLER_ID_EDEFAULT.equals(stateHandlerId);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (stateHandlerId: ");
        result.append(stateHandlerId);
        result.append(')');
        return result.toString();
    }

} //VariationPointImpl
