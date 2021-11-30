/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.UncertaintyVariationModelFactory;
import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.VariationPoint;
import UncertaintyVariationModel.VaryingAllocationContext;
import UncertaintyVariationModel.VaryingBranch;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.pcm.PcmPackage;

import org.palladiosimulator.pcm.allocation.AllocationPackage;

import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UncertaintyVariationModelPackageImpl extends EPackageImpl implements UncertaintyVariationModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uncertaintyVariationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varyingAllocationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varyingBranchEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see UncertaintyVariationModel.UncertaintyVariationModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UncertaintyVariationModelPackageImpl() {
		super(eNS_URI, UncertaintyVariationModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link UncertaintyVariationModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UncertaintyVariationModelPackage init() {
		if (isInited) return (UncertaintyVariationModelPackage)EPackage.Registry.INSTANCE.getEPackage(UncertaintyVariationModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUncertaintyVariationModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UncertaintyVariationModelPackageImpl theUncertaintyVariationModelPackage = registeredUncertaintyVariationModelPackage instanceof UncertaintyVariationModelPackageImpl ? (UncertaintyVariationModelPackageImpl)registeredUncertaintyVariationModelPackage : new UncertaintyVariationModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUncertaintyVariationModelPackage.createPackageContents();

		// Initialize created meta-data
		theUncertaintyVariationModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUncertaintyVariationModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UncertaintyVariationModelPackage.eNS_URI, theUncertaintyVariationModelPackage);
		return theUncertaintyVariationModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUncertaintyVariations() {
		return uncertaintyVariationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUncertaintyVariations_VariationPoints() {
		return (EReference)uncertaintyVariationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPoint() {
		return variationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVaryingAllocationContext() {
		return varyingAllocationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVaryingAllocationContext_TargetResourceVariations() {
		return (EReference)varyingAllocationContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVaryingAllocationContext_AllocationContext() {
		return (EReference)varyingAllocationContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVaryingBranch() {
		return varyingBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVaryingBranch_BranchActions() {
		return (EReference)varyingBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVaryingBranch_Branches() {
		return (EReference)varyingBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelFactory getUncertaintyVariationModelFactory() {
		return (UncertaintyVariationModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		uncertaintyVariationsEClass = createEClass(UNCERTAINTY_VARIATIONS);
		createEReference(uncertaintyVariationsEClass, UNCERTAINTY_VARIATIONS__VARIATION_POINTS);

		variationPointEClass = createEClass(VARIATION_POINT);

		varyingAllocationContextEClass = createEClass(VARYING_ALLOCATION_CONTEXT);
		createEReference(varyingAllocationContextEClass, VARYING_ALLOCATION_CONTEXT__TARGET_RESOURCE_VARIATIONS);
		createEReference(varyingAllocationContextEClass, VARYING_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT);

		varyingBranchEClass = createEClass(VARYING_BRANCH);
		createEReference(varyingBranchEClass, VARYING_BRANCH__BRANCH_ACTIONS);
		createEReference(varyingBranchEClass, VARYING_BRANCH__BRANCHES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		varyingAllocationContextEClass.getESuperTypes().add(this.getVariationPoint());
		varyingBranchEClass.getESuperTypes().add(this.getVariationPoint());

		// Initialize classes, features, and operations; add parameters
		initEClass(uncertaintyVariationsEClass, UncertaintyVariations.class, "UncertaintyVariations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUncertaintyVariations_VariationPoints(), this.getVariationPoint(), null, "variationPoints", null, 0, -1, UncertaintyVariations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class, "VariationPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varyingAllocationContextEClass, VaryingAllocationContext.class, "VaryingAllocationContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVaryingAllocationContext_TargetResourceVariations(), theResourceenvironmentPackage.getResourceContainer(), null, "targetResourceVariations", null, 0, -1, VaryingAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVaryingAllocationContext_AllocationContext(), theAllocationPackage.getAllocationContext(), null, "allocationContext", null, 1, 1, VaryingAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varyingBranchEClass, VaryingBranch.class, "VaryingBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVaryingBranch_BranchActions(), theSeffPackage.getBranchAction(), null, "branchActions", null, 0, -1, VaryingBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVaryingBranch_Branches(), theUsagemodelPackage.getBranch(), null, "branches", null, 0, -1, VaryingBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UncertaintyVariationModelPackageImpl
