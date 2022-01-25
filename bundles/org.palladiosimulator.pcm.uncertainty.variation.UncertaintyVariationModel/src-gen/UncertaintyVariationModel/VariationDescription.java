/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.VariationDescription#getTargetVariations <em>Target Variations</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription()
 * @model
 * @generated
 */
public interface VariationDescription extends EObject {
	/**
     * Returns the value of the '<em><b>Target Variations</b></em>' containment reference list.
     * The list contents are of type {@link UncertaintyVariationModel.Value}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Target Variations</em>' containment reference list.
     * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription_TargetVariations()
     * @model containment="true" required="true"
     * @generated
     */
	EList<Value> getTargetVariations();

} // VariationDescription
