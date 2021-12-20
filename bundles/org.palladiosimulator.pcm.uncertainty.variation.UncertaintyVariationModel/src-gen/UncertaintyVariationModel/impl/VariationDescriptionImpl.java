/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.VariationDescription;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
	 * The cached value of the '{@link #getTargetVariations() <em>Target Variations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> targetVariations;

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
	public EList<Identifier> getTargetVariations() {
		if (targetVariations == null) {
			targetVariations = new EObjectResolvingEList<Identifier>(Identifier.class, this, UncertaintyVariationModelPackage.VARIATION_DESCRIPTION__TARGET_VARIATIONS);
		}
		return targetVariations;
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
				getTargetVariations().addAll((Collection<? extends Identifier>)newValue);
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
