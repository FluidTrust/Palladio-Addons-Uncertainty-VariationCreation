/**
 */
package UncertaintyVariationModel.impl;

import UncertaintyVariationModel.PrimitiveValue;
import UncertaintyVariationModel.UncertaintyVariationModelFactory;
import UncertaintyVariationModel.UncertaintyVariationModelPackage;
import UncertaintyVariationModel.UncertaintyVariations;
import UncertaintyVariationModel.Value;
import UncertaintyVariationModel.ValueCollection;
import UncertaintyVariationModel.VariationDescription;
import UncertaintyVariationModel.VariationPoint;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UncertaintyVariationModelPackageImpl extends EPackageImpl implements UncertaintyVariationModelPackage
{
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
	private EClass variationDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueCollectionEClass = null;

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
	private UncertaintyVariationModelPackageImpl()
	{
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
	public static UncertaintyVariationModelPackage init()
	{
		if (isInited) return (UncertaintyVariationModelPackage)EPackage.Registry.INSTANCE.getEPackage(UncertaintyVariationModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUncertaintyVariationModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UncertaintyVariationModelPackageImpl theUncertaintyVariationModelPackage = registeredUncertaintyVariationModelPackage instanceof UncertaintyVariationModelPackageImpl ? (UncertaintyVariationModelPackageImpl)registeredUncertaintyVariationModelPackage : new UncertaintyVariationModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

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
	public EClass getUncertaintyVariations()
	{
		return uncertaintyVariationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUncertaintyVariations_VariationPoints()
	{
		return (EReference)uncertaintyVariationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPoint()
	{
		return variationPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_VaryingSubjects()
	{
		return (EReference)variationPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_VariationDescription()
	{
		return (EReference)variationPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariationPoint_StateHandlerId()
	{
		return (EAttribute)variationPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariationPoint_EntityName()
	{
		return (EAttribute)variationPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationDescription()
	{
		return variationDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationDescription_TargetVariations()
	{
		return (EReference)variationDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationDescription_Variationpoint()
	{
		return (EReference)variationDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue()
	{
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValue_Variationdescription()
	{
		return (EReference)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveValue()
	{
		return primitiveValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveValue_Link()
	{
		return (EReference)primitiveValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueCollection()
	{
		return valueCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueCollection_Links()
	{
		return (EReference)valueCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UncertaintyVariationModelFactory getUncertaintyVariationModelFactory()
	{
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
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		uncertaintyVariationsEClass = createEClass(UNCERTAINTY_VARIATIONS);
		createEReference(uncertaintyVariationsEClass, UNCERTAINTY_VARIATIONS__VARIATION_POINTS);

		variationPointEClass = createEClass(VARIATION_POINT);
		createEReference(variationPointEClass, VARIATION_POINT__VARYING_SUBJECTS);
		createEReference(variationPointEClass, VARIATION_POINT__VARIATION_DESCRIPTION);
		createEAttribute(variationPointEClass, VARIATION_POINT__STATE_HANDLER_ID);
		createEAttribute(variationPointEClass, VARIATION_POINT__ENTITY_NAME);

		variationDescriptionEClass = createEClass(VARIATION_DESCRIPTION);
		createEReference(variationDescriptionEClass, VARIATION_DESCRIPTION__TARGET_VARIATIONS);
		createEReference(variationDescriptionEClass, VARIATION_DESCRIPTION__VARIATIONPOINT);

		valueEClass = createEClass(VALUE);
		createEReference(valueEClass, VALUE__VARIATIONDESCRIPTION);

		primitiveValueEClass = createEClass(PRIMITIVE_VALUE);
		createEReference(primitiveValueEClass, PRIMITIVE_VALUE__LINK);

		valueCollectionEClass = createEClass(VALUE_COLLECTION);
		createEReference(valueCollectionEClass, VALUE_COLLECTION__LINKS);
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
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		primitiveValueEClass.getESuperTypes().add(this.getValue());
		valueCollectionEClass.getESuperTypes().add(this.getValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(uncertaintyVariationsEClass, UncertaintyVariations.class, "UncertaintyVariations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUncertaintyVariations_VariationPoints(), this.getVariationPoint(), null, "variationPoints", null, 0, -1, UncertaintyVariations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class, "VariationPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationPoint_VaryingSubjects(), theIdentifierPackage.getIdentifier(), null, "varyingSubjects", null, 1, -1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariationPoint_VariationDescription(), this.getVariationDescription(), this.getVariationDescription_Variationpoint(), "variationDescription", null, 0, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariationPoint_StateHandlerId(), ecorePackage.getEString(), "stateHandlerId", null, 1, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariationPoint_EntityName(), ecorePackage.getEString(), "entityName", null, 0, 1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationDescriptionEClass, VariationDescription.class, "VariationDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationDescription_TargetVariations(), this.getValue(), this.getValue_Variationdescription(), "targetVariations", null, 1, -1, VariationDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariationDescription_Variationpoint(), this.getVariationPoint(), this.getVariationPoint_VariationDescription(), "variationpoint", null, 0, 1, VariationDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValue_Variationdescription(), this.getVariationDescription(), this.getVariationDescription_TargetVariations(), "variationdescription", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveValueEClass, PrimitiveValue.class, "PrimitiveValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveValue_Link(), theIdentifierPackage.getIdentifier(), null, "link", null, 0, 1, PrimitiveValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueCollectionEClass, ValueCollection.class, "ValueCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueCollection_Links(), theIdentifierPackage.getIdentifier(), null, "links", null, 0, -1, ValueCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UncertaintyVariationModelPackageImpl
