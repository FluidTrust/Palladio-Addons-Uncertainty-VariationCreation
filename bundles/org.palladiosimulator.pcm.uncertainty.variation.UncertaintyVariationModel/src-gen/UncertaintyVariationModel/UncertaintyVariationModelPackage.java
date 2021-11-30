/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see UncertaintyVariationModel.UncertaintyVariationModelFactory
 * @model kind="package"
 * @generated
 */
public interface UncertaintyVariationModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UncertaintyVariationModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/pcm/UncertaintyVariationModel/v0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "UncertaintyVariationModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UncertaintyVariationModelPackage eINSTANCE = UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.UncertaintyVariationsImpl <em>Uncertainty Variations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationsImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getUncertaintyVariations()
	 * @generated
	 */
	int UNCERTAINTY_VARIATIONS = 0;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS__VARIATION_POINTS = 0;

	/**
	 * The number of structural features of the '<em>Uncertainty Variations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Uncertainty Variations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.VariationPointImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 1;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.VaryingAllocationContextImpl <em>Varying Allocation Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.VaryingAllocationContextImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVaryingAllocationContext()
	 * @generated
	 */
	int VARYING_ALLOCATION_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Target Resource Variations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Varying Allocation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_ALLOCATION_CONTEXT_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Varying Allocation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_ALLOCATION_CONTEXT_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.VaryingBranchImpl <em>Varying Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.VaryingBranchImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVaryingBranch()
	 * @generated
	 */
	int VARYING_BRANCH = 3;

	/**
	 * The feature id for the '<em><b>Branch Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_BRANCH__BRANCH_ACTIONS = VARIATION_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_BRANCH__BRANCHES = VARIATION_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Varying Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_BRANCH_FEATURE_COUNT = VARIATION_POINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Varying Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARYING_BRANCH_OPERATION_COUNT = VARIATION_POINT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.UncertaintyVariations <em>Uncertainty Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uncertainty Variations</em>'.
	 * @see UncertaintyVariationModel.UncertaintyVariations
	 * @generated
	 */
	EClass getUncertaintyVariations();

	/**
	 * Returns the meta object for the containment reference list '{@link UncertaintyVariationModel.UncertaintyVariations#getVariationPoints <em>Variation Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variation Points</em>'.
	 * @see UncertaintyVariationModel.UncertaintyVariations#getVariationPoints()
	 * @see #getUncertaintyVariations()
	 * @generated
	 */
	EReference getUncertaintyVariations_VariationPoints();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see UncertaintyVariationModel.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.VaryingAllocationContext <em>Varying Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Varying Allocation Context</em>'.
	 * @see UncertaintyVariationModel.VaryingAllocationContext
	 * @generated
	 */
	EClass getVaryingAllocationContext();

	/**
	 * Returns the meta object for the reference list '{@link UncertaintyVariationModel.VaryingAllocationContext#getTargetResourceVariations <em>Target Resource Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Resource Variations</em>'.
	 * @see UncertaintyVariationModel.VaryingAllocationContext#getTargetResourceVariations()
	 * @see #getVaryingAllocationContext()
	 * @generated
	 */
	EReference getVaryingAllocationContext_TargetResourceVariations();

	/**
	 * Returns the meta object for the reference '{@link UncertaintyVariationModel.VaryingAllocationContext#getAllocationContext <em>Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation Context</em>'.
	 * @see UncertaintyVariationModel.VaryingAllocationContext#getAllocationContext()
	 * @see #getVaryingAllocationContext()
	 * @generated
	 */
	EReference getVaryingAllocationContext_AllocationContext();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.VaryingBranch <em>Varying Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Varying Branch</em>'.
	 * @see UncertaintyVariationModel.VaryingBranch
	 * @generated
	 */
	EClass getVaryingBranch();

	/**
	 * Returns the meta object for the reference list '{@link UncertaintyVariationModel.VaryingBranch#getBranchActions <em>Branch Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Branch Actions</em>'.
	 * @see UncertaintyVariationModel.VaryingBranch#getBranchActions()
	 * @see #getVaryingBranch()
	 * @generated
	 */
	EReference getVaryingBranch_BranchActions();

	/**
	 * Returns the meta object for the reference list '{@link UncertaintyVariationModel.VaryingBranch#getBranches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Branches</em>'.
	 * @see UncertaintyVariationModel.VaryingBranch#getBranches()
	 * @see #getVaryingBranch()
	 * @generated
	 */
	EReference getVaryingBranch_Branches();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UncertaintyVariationModelFactory getUncertaintyVariationModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.UncertaintyVariationsImpl <em>Uncertainty Variations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationsImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getUncertaintyVariations()
		 * @generated
		 */
		EClass UNCERTAINTY_VARIATIONS = eINSTANCE.getUncertaintyVariations();

		/**
		 * The meta object literal for the '<em><b>Variation Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNCERTAINTY_VARIATIONS__VARIATION_POINTS = eINSTANCE.getUncertaintyVariations_VariationPoints();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.VariationPointImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.VaryingAllocationContextImpl <em>Varying Allocation Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.VaryingAllocationContextImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVaryingAllocationContext()
		 * @generated
		 */
		EClass VARYING_ALLOCATION_CONTEXT = eINSTANCE.getVaryingAllocationContext();

		/**
		 * The meta object literal for the '<em><b>Target Resource Variations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS = eINSTANCE.getVaryingAllocationContext_TargetResourceVariations();

		/**
		 * The meta object literal for the '<em><b>Allocation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT = eINSTANCE.getVaryingAllocationContext_AllocationContext();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.VaryingBranchImpl <em>Varying Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.VaryingBranchImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVaryingBranch()
		 * @generated
		 */
		EClass VARYING_BRANCH = eINSTANCE.getVaryingBranch();

		/**
		 * The meta object literal for the '<em><b>Branch Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARYING_BRANCH__BRANCH_ACTIONS = eINSTANCE.getVaryingBranch_BranchActions();

		/**
		 * The meta object literal for the '<em><b>Branches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARYING_BRANCH__BRANCHES = eINSTANCE.getVaryingBranch_Branches();

	}

} //UncertaintyVariationModelPackage
