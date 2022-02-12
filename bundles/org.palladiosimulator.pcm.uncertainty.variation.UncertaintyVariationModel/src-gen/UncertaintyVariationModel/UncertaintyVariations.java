/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertainty Variations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.UncertaintyVariations#getVariationPoints <em>Variation Points</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getUncertaintyVariations()
 * @model
 * @generated
 */
public interface UncertaintyVariations extends EObject
{
	/**
	 * Returns the value of the '<em><b>Variation Points</b></em>' containment reference list.
	 * The list contents are of type {@link UncertaintyVariationModel.VariationPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Points</em>' containment reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getUncertaintyVariations_VariationPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariationPoint> getVariationPoints();

} // UncertaintyVariations
