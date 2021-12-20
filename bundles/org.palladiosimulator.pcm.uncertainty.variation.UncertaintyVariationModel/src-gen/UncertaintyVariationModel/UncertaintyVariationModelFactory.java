/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage
 * @generated
 */
public interface UncertaintyVariationModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UncertaintyVariationModelFactory eINSTANCE = UncertaintyVariationModel.impl.UncertaintyVariationModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Uncertainty Variations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uncertainty Variations</em>'.
	 * @generated
	 */
	UncertaintyVariations createUncertaintyVariations();

	/**
	 * Returns a new object of class '<em>Varying Allocation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Varying Allocation Context</em>'.
	 * @generated
	 */
	VaryingAllocationContext createVaryingAllocationContext();

	/**
	 * Returns a new object of class '<em>Varying Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Varying Branch</em>'.
	 * @generated
	 */
	VaryingBranch createVaryingBranch();

	/**
	 * Returns a new object of class '<em>Varying Assembly Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Varying Assembly Context</em>'.
	 * @generated
	 */
	VaryingAssemblyContext createVaryingAssemblyContext();

	/**
	 * Returns a new object of class '<em>Variation Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Description</em>'.
	 * @generated
	 */
	VariationDescription createVariationDescription();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UncertaintyVariationModelPackage getUncertaintyVariationModelPackage();

} //UncertaintyVariationModelFactory
