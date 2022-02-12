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
 *   <li>{@link UncertaintyVariationModel.VariationDescription#getVariationpoint <em>Variationpoint</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription()
 * @model
 * @generated
 */
public interface VariationDescription extends EObject
{
	/**
	 * Returns the value of the '<em><b>Target Variations</b></em>' containment reference list.
	 * The list contents are of type {@link UncertaintyVariationModel.Value}.
	 * It is bidirectional and its opposite is '{@link UncertaintyVariationModel.Value#getVariationdescription <em>Variationdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variations</em>' containment reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription_TargetVariations()
	 * @see UncertaintyVariationModel.Value#getVariationdescription
	 * @model opposite="variationdescription" containment="true" required="true"
	 * @generated
	 */
	EList<Value> getTargetVariations();

	/**
	 * Returns the value of the '<em><b>Variationpoint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link UncertaintyVariationModel.VariationPoint#getVariationDescription <em>Variation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variationpoint</em>' container reference.
	 * @see #setVariationpoint(VariationPoint)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationDescription_Variationpoint()
	 * @see UncertaintyVariationModel.VariationPoint#getVariationDescription
	 * @model opposite="variationDescription" transient="false"
	 * @generated
	 */
	VariationPoint getVariationpoint();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.VariationDescription#getVariationpoint <em>Variationpoint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variationpoint</em>' container reference.
	 * @see #getVariationpoint()
	 * @generated
	 */
	void setVariationpoint(VariationPoint value);

} // VariationDescription
