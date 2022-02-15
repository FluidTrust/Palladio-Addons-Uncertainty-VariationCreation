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
public interface UncertaintyVariationModelFactory extends EFactory
{
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
	 * Returns a new object of class '<em>Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Point</em>'.
	 * @generated
	 */
	VariationPoint createVariationPoint();

	/**
	 * Returns a new object of class '<em>Variation Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Description</em>'.
	 * @generated
	 */
	VariationDescription createVariationDescription();

	/**
	 * Returns a new object of class '<em>Primitive Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Value</em>'.
	 * @generated
	 */
	PrimitiveValue createPrimitiveValue();

	/**
	 * Returns a new object of class '<em>Value Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Collection</em>'.
	 * @generated
	 */
	ValueCollection createValueCollection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UncertaintyVariationModelPackage getUncertaintyVariationModelPackage();

} //UncertaintyVariationModelFactory
