/**
 */
package UncertaintyVariationModel;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.ValueCollection#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getValueCollection()
 * @model
 * @generated
 */
public interface ValueCollection extends Value
{
	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.identifier.Identifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getValueCollection_Links()
	 * @model
	 * @generated
	 */
	EList<Identifier> getLinks();

} // ValueCollection
