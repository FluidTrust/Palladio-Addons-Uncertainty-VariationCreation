/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.ValueCollection;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.ValueCollectionImpl#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueCollectionImpl extends ValueImpl implements ValueCollection {
    /**
     * The cached value of the '{@link #getLinks() <em>Links</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLinks()
     * @generated
     * @ordered
     */
    protected EList<Identifier> links;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueCollectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UncertaintyVariationModelPackage.Literals.VALUE_COLLECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Identifier> getLinks() {
        if (links == null) {
            links = new EObjectResolvingEList<Identifier>(Identifier.class, this, UncertaintyVariationModelPackage.VALUE_COLLECTION__LINKS);
        }
        return links;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UncertaintyVariationModelPackage.VALUE_COLLECTION__LINKS:
                return getLinks();
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
            case UncertaintyVariationModelPackage.VALUE_COLLECTION__LINKS:
                getLinks().clear();
                getLinks().addAll((Collection<? extends Identifier>)newValue);
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
            case UncertaintyVariationModelPackage.VALUE_COLLECTION__LINKS:
                getLinks().clear();
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
            case UncertaintyVariationModelPackage.VALUE_COLLECTION__LINKS:
                return links != null && !links.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ValueCollectionImpl
