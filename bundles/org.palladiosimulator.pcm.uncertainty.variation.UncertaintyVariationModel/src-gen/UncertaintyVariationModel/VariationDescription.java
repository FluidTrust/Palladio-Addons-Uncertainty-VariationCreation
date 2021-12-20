/**
 */
package UncertaintyVariationModel;

import de.uka.ipd.sdq.identifier.Identifier;

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
	 * Returns the value of the '<em><b>Target Variations</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.identifier.Identifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variations</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription_TargetVariations()
	 * @model
	 * @generated
	 */
	EList<Identifier> getTargetVariations();

} // VariationDescription
