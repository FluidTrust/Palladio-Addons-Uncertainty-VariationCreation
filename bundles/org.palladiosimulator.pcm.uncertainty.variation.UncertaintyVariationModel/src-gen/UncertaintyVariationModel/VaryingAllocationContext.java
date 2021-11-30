/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.common.util.EList;

import org.palladiosimulator.pcm.allocation.AllocationContext;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Varying Allocation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link UncertaintyVariationModel.VaryingAllocationContext#getTargetResourceVariations <em>Target Resource Variations</em>}</li>
 *   <li>{@link UncertaintyVariationModel.VaryingAllocationContext#getAllocationContext <em>Allocation Context</em>}</li>
 * </ul>
 *
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingAllocationContext()
 * @model
 * @generated
 */
public interface VaryingAllocationContext extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Target Resource Variations</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.pcm.resourceenvironment.ResourceContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource Variations</em>' reference list.
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingAllocationContext_TargetResourceVariations()
	 * @model
	 * @generated
	 */
	EList<ResourceContainer> getTargetResourceVariations();

	/**
	 * Returns the value of the '<em><b>Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Context</em>' reference.
	 * @see #setAllocationContext(AllocationContext)
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#getVaryingAllocationContext_AllocationContext()
	 * @model required="true"
	 * @generated
	 */
	AllocationContext getAllocationContext();

	/**
	 * Sets the value of the '{@link UncertaintyVariationModel.VaryingAllocationContext#getAllocationContext <em>Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Context</em>' reference.
	 * @see #getAllocationContext()
	 * @generated
	 */
	void setAllocationContext(AllocationContext value);

} // VaryingAllocationContext
