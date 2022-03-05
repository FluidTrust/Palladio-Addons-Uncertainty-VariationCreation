/**
 */
package UncertaintyVariationModel;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link UncertaintyVariationModel.VariationPoint#getStateHandlerId <em>State Handler Id</em>}</li>
 *   <li>{@link UncertaintyVariationModel.VariationPoint#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface VariationPoint extends CDOObject
{
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
	 * It is bidirectional and its opposite is '{@link UncertaintyVariationModel.VariationDescription#getVariationpoint <em>Variationpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Description</em>' containment reference.
	 * @see #setVariationDescription(VariationDescription)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint_VariationDescription()
	 * @see UncertaintyVariationModel.VariationDescription#getVariationpoint
	 * @model opposite="variationpoint" containment="true"
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

	/**
	 * Returns the value of the '<em><b>State Handler Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Handler Id</em>' attribute.
	 * @see #setStateHandlerId(String)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint_StateHandlerId()
	 * @model required="true"
	 * @generated
	 */
	String getStateHandlerId();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.VariationPoint#getStateHandlerId <em>State Handler Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Handler Id</em>' attribute.
	 * @see #getStateHandlerId()
	 * @generated
	 */
	void setStateHandlerId(String value);

	/**
	 * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Name</em>' attribute.
	 * @see #setEntityName(String)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVariationPoint_EntityName()
	 * @model
	 * @generated
	 */
	String getEntityName();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.VariationPoint#getEntityName <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity Name</em>' attribute.
	 * @see #getEntityName()
	 * @generated
	 */
	void setEntityName(String value);

} // VariationPoint
