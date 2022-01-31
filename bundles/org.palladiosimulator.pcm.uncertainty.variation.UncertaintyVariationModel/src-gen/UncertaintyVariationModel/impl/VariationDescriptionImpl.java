/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.Value;
import UncertaintyVariationModel.VariationDescription;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variation Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.VariationDescriptionImpl#getTargetVariations <em>Target Variations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariationDescriptionImpl extends MinimalEObjectImpl.Container implements VariationDescription {
    /**
     * The cached value of the '{@link #getTargetVariations() <em>Target Variations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetVariations()
     * @generated
     * @ordered
     */
    protected EList<Value> targetVariations;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariationDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UncertaintyVariationModelPackage.Literals.VARIATION_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Value> getTargetVariations() {
        if (targetVariations == null) {
            targetVariations = new EObjectContainmentEList<Value>(Value.class, this, UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS);
        }
        return targetVariations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
                return ((InternalEList<?>)getTargetVariations()).basicRemove(otherEnd, msgs);
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
            case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
                return getTargetVariations();
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
            case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
                getTargetVariations().clear();
                getTargetVariations().addAll((Collection<? extends Value>)newValue);
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
            case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
                getTargetVariations().clear();
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
            case UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS:
                return targetVariations != null && !targetVariations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //VariationDescriptionImpl
