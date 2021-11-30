/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.VaryingBranch;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.palladiosimulator.pcm.seff.BranchAction;

import org.palladiosimulator.pcm.usagemodel.Branch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Varying Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.impl.VaryingBranchImpl#getBranchActions <em>Branch Actions</em>}</li>
 *   <li>{@link UncertaintyVariationModel.impl.VaryingBranchImpl#getBranches <em>Branches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VaryingBranchImpl extends VariationPointImpl implements VaryingBranch {
	/**
	 * The cached value of the '{@link #getBranchActions() <em>Branch Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchActions()
	 * @generated
	 * @ordered
	 */
	protected EList<BranchAction> branchActions;

	/**
	 * The cached value of the '{@link #getBranches() <em>Branches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<Branch> branches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VaryingBranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UncertaintyVariationModelPackage.Literals.VARYING_BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BranchAction> getBranchActions() {
		if (branchActions == null) {
			branchActions = new EObjectResolvingEList<BranchAction>(BranchAction.class, this, UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCH_ACTIONS);
		}
		return branchActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Branch> getBranches() {
		if (branches == null) {
			branches = new EObjectResolvingEList<Branch>(Branch.class, this, UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCHES);
		}
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCH_ACTIONS:
				return getBranchActions();
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCHES:
				return getBranches();
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
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCH_ACTIONS:
				getBranchActions().clear();
				getBranchActions().addAll((Collection<? extends BranchAction>)newValue);
				return;
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCHES:
				getBranches().clear();
				getBranches().addAll((Collection<? extends Branch>)newValue);
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
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCH_ACTIONS:
				getBranchActions().clear();
				return;
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCHES:
				getBranches().clear();
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
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCH_ACTIONS:
				return branchActions != null && !branchActions.isEmpty();
			case UncertaintyVariationModelPackage.VARYING_BRANCH__BRANCHES:
				return branches != null && !branches.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VaryingBranchImpl
