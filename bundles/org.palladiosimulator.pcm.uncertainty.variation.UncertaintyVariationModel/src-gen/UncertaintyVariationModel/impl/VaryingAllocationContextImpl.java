/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.VaryingAllocationContext;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.palladiosimulator.pcm.allocation.AllocationContext;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Varying Allocation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.VaryingAllocationContextImpl#getTargetResourceVariations <em>Target Resource Variations</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VaryingAllocationContextImpl#getAllocationContext <em>Allocation Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VaryingAllocationContextImpl extends VariationPointImpl implements VaryingAllocationContext {
	/**
	 * The cached value of the '{@link #getTargetResourceVariations() <em>Target Resource Variations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetResourceVariations()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceContainer> targetResourceVariations;

	/**
	 * The cached value of the '{@link #getAllocationContext() <em>Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VaryingAllocationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyVariationModelPackage.Literals.VARYING_ALLOCATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceContainer> getTargetResourceVariations() {
		if (targetResourceVariations == null) {
			targetResourceVariations = new EObjectResolvingEList<ResourceContainer>(ResourceContainer.class, this, UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS);
		}
		return targetResourceVariations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext() {
		if (allocationContext != null && ((EObject)allocationContext).eIsProxy()) {
			InternalEObject oldAllocationContext = (InternalEObject)allocationContext;
			allocationContext = (AllocationContext)eResolveProxy(oldAllocationContext);
			if (allocationContext != oldAllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT, oldAllocationContext, allocationContext));
			}
		}
		return allocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext() {
		return allocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext(AllocationContext newAllocationContext) {
		AllocationContext oldAllocationContext = allocationContext;
		allocationContext = newAllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT, oldAllocationContext, allocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS:
				return getTargetResourceVariations();
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT:
				if (resolve) return getAllocationContext();
				return basicGetAllocationContext();
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
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS:
				getTargetResourceVariations().clear();
				getTargetResourceVariations().addAll((Collection<? extends ResourceContainer>)newValue);
				return;
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT:
				setAllocationContext((AllocationContext)newValue);
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
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS:
				getTargetResourceVariations().clear();
				return;
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT:
				setAllocationContext((AllocationContext)null);
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
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS:
				return targetResourceVariations != null && !targetResourceVariations.isEmpty();
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT:
				return allocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //VaryingAllocationContextImpl
