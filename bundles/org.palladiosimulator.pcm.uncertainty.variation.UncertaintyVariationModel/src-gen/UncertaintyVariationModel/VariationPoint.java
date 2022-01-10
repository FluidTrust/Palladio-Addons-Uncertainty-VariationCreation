/**
 */
package UncertaintyVariationModel;

import de.uka.ipd.sdq.identifier.Identifier;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.VariationPoint#getVaryingSubjects <em>Varying Subjects</em>}</li>
 *   <li>{@link UncertaintyVariationModel.VariationPoint#getVariationDescription <em>Variation Description</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface VariationPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Varying Subjects</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.identifier.Identifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varying Subjects</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint_VaryingSubjects()
	 * @model required="true"
	 * @generated
	 */
	EList<Identifier> getVaryingSubjects();

	/**
	 * Returns the value of the '<em><b>Variation Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Description</em>' containment reference.
	 * @see #setVariationDescription(VariationDescription)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint_VariationDescription()
	 * @model containment="true"
	 * @generated
	 */
	VariationDescription getVariationDescription();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.VariationPoint#getVariationDescription <em>Variation Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variation Description</em>' containment reference.
	 * @see #getVariationDescription()
	 * @generated
	 */
	void setVariationDescription(VariationDescription value);

} // VariationPoint
