/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariationModelPackage;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
public class PrimitiveValueImpl extends ValueImpl implements PrimitiveValue {
    /**
     * The cached value of the '{@link #getLink() <em>Link</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLink()
     * @generated
     * @ordered
     */
    protected Identifier link;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimitiveValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UncertaintyVariationModelPackage.Literals.PRIMITIVE_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Identifier getLink() {
        if (link != null && ((EObject)link).eIsProxy()) {
            InternalEObject oldLink = (InternalEObject)link;
            link = (Identifier)eResolveProxy(oldLink);
            if (link != oldLink) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK, oldLink, link));
            }
        }
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Identifier basicGetLink() {
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLink(Identifier newLink) {
        Identifier oldLink = link;
        link = newLink;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK, oldLink, link));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
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
    public void eUnset(int featureID) {
        switch (featureID) {
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.PRIMITIVE_VALUE__LINK:
                return link != null;
        }
        return super.eIsSet(featureID);
    }

} //PrimitiveValueImpl
