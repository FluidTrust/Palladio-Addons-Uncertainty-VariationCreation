/**
 */
package UncertaintyVariationModel.util;

import UncertaintyVariationModel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage
 * @generated
 */
public class UncertaintyVariationModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UncertaintyVariationModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelSwitch() {
		if (modelPackage == null) {
			modelPackage = UncertaintyVariationModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UncertaintyVariationModelPackage.UNCERTAINTY_VARIATIONS: {
				UncertaintyVariations uncertaintyVariations = (UncertaintyVariations)theEObject;
				T result = caseUncertaintyVariations(uncertaintyVariations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyVariationModelPackage.VARIATION_POINT: {
				VariationPoint variationPoint = (VariationPoint)theEObject;
				T result = caseVariationPoint(variationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyVariationModelPackage.VARYING_ALLOCATION_CONTEXT: {
				VaryingAllocationContext varyingAllocationContext = (VaryingAllocationContext)theEObject;
				T result = caseVaryingAllocationContext(varyingAllocationContext);
				if (result == null) result = caseVariationPoint(varyingAllocationContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UncertaintyVariationModelPackage.VARYING_BRANCH: {
				VaryingBranch varyingBranch = (VaryingBranch)theEObject;
				T result = caseVaryingBranch(varyingBranch);
				if (result == null) result = caseVariationPoint(varyingBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uncertainty Variations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uncertainty Variations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUncertaintyVariations(UncertaintyVariations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariationPoint(VariationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Varying Allocation Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Varying Allocation Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVaryingAllocationContext(VaryingAllocationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Varying Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Varying Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVaryingBranch(VaryingBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UncertaintyVariationModelSwitch
