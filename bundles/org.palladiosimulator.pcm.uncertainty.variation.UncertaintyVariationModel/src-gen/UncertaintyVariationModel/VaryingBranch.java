/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.common.util.EList;

import org.palladiosimulator.pcm.seff.BranchAction;

import org.palladiosimulator.pcm.usagemodel.Branch;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Varying Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.VaryingBranch#getBranchActions <em>Branch Actions</em>}</li>
 *   <li>{@link UncertaintyVariationModel.VaryingBranch#getBranches <em>Branches</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingBranch()
 * @model
 * @generated
 */
public interface VaryingBranch extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Branch Actions</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.pcm.seff.BranchAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Actions</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingBranch_BranchActions()
	 * @model
	 * @generated
	 */
	EList<BranchAction> getBranchActions();

	/**
	 * Returns the value of the '<em><b>Branches</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.pcm.usagemodel.Branch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingBranch_Branches()
	 * @model
	 * @generated
	 */
	EList<Branch> getBranches();

} // VaryingBranch
