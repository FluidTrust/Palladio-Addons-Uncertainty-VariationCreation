/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.Value#getVariationdescription <em>Variationdescription</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getValue()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Value extends CDOObject
{
	/**
	 * Returns the value of the '<em><b>Variationdescription</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link UncertaintyVariationModel.VariationDescription#getTargetVariations <em>Target Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variationdescription</em>' container reference.
	 * @see #setVariationdescription(VariationDescription)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getValue_Variationdescription()
	 * @see UncertaintyVariationModel.VariationDescription#getTargetVariations
	 * @model opposite="targetVariations" transient="false"
	 * @generated
	 */
	VariationDescription getVariationdescription();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.Value#getVariationdescription <em>Variationdescription</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variationdescription</em>' container reference.
	 * @see #getVariationdescription()
	 * @generated
	 */
	void setVariationdescription(VariationDescription value);

} // Value
