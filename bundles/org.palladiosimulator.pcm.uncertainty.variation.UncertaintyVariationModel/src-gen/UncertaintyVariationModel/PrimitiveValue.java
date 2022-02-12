/**
 */
package UncertaintyVariationModel;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.PrimitiveValue#getLink <em>Link</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getPrimitiveValue()
 * @model
 * @generated
 */
public interface PrimitiveValue extends Value
{
	/**
	 * Returns the value of the '<em><b>Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' reference.
	 * @see #setLink(Identifier)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getPrimitiveValue_Link()
	 * @model
	 * @generated
	 */
	Identifier getLink();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.PrimitiveValue#getLink <em>Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(Identifier value);

} // PrimitiveValue
