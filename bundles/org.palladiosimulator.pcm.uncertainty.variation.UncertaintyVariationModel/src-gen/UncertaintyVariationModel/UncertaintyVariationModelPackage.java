/**
 */
package UncertaintyVariationModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see UncertaintyVariationModel.UncertaintyVariationModelFactory
 * @model kind="package"
 * @generated
 */
public interface UncertaintyVariationModelPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UncertaintyVariationModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/pcm/UncertaintyVariationModel/v0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "UncertaintyVariationModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UncertaintyVariationModelPackage eINSTANCE = UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.UncertaintyVariationsImpl <em>Uncertainty Variations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationsImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getUncertaintyVariations()
	 * @generated
	 */
	int UNCERTAINTY_VARIATIONS = 0;

	/**
	 * The feature id for the '<em><b>Variation Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS__VARIATION_POINTS = 0;

	/**
	 * The number of structural features of the '<em>Uncertainty Variations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Uncertainty Variations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCERTAINTY_VARIATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.VariationPointImpl <em>Variation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.VariationPointImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationPoint()
	 * @generated
	 */
	int VARIATION_POINT = 1;

	/**
	 * The feature id for the '<em><b>Varying Subjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARYING_SUBJECTS = 0;

	/**
	 * The feature id for the '<em><b>Variation Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__VARIATION_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>State Handler Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__STATE_HANDLER_ID = 2;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT__ENTITY_NAME = 3;

	/**
	 * The number of structural features of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Variation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.VariationDescriptionImpl <em>Variation Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.VariationDescriptionImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationDescription()
	 * @generated
	 */
	int VARIATION_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Target Variations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_DESCRIPTION__TARGET_VARIATIONS = 0;

	/**
	 * The feature id for the '<em><b>Variationpoint</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_DESCRIPTION__VARIATIONPOINT = 1;

	/**
	 * The number of structural features of the '<em>Variation Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_DESCRIPTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variation Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.ValueImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 3;

	/**
	 * The feature id for the '<em><b>Variationdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VARIATIONDESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.PrimitiveValueImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getPrimitiveValue()
	 * @generated
	 */
	int PRIMITIVE_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Variationdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__VARIATIONDESCRIPTION = VALUE__VARIATIONDESCRIPTION;

	/**
	 * The feature id for the '<em><b>Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__LINK = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link UncertaintyVariationModel.impl.ValueCollectionImpl <em>Value Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UncertaintyVariationModel.impl.ValueCollectionImpl
	 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getValueCollection()
	 * @generated
	 */
	int VALUE_COLLECTION = 5;

	/**
	 * The feature id for the '<em><b>Variationdescription</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_COLLECTION__VARIATIONDESCRIPTION = VALUE__VARIATIONDESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_COLLECTION__LINKS = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_COLLECTION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_COLLECTION_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.UncertaintyVariations <em>Uncertainty Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uncertainty Variations</em>'.
	 * @see UncertaintyVariationModel.UncertaintyVariations
	 * @generated
	 */
	EClass getUncertaintyVariations();

	/**
	 * Returns the meta object for the containment reference list '{@link UncertaintyVariationModel.UncertaintyVariations#getVariationPoints <em>Variation Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variation Points</em>'.
	 * @see UncertaintyVariationModel.UncertaintyVariations#getVariationPoints()
	 * @see #getUncertaintyVariations()
	 * @generated
	 */
	EReference getUncertaintyVariations_VariationPoints();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.VariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Point</em>'.
	 * @see UncertaintyVariationModel.VariationPoint
	 * @generated
	 */
	EClass getVariationPoint();

	/**
	 * Returns the meta object for the reference list '{@link UncertaintyVariationModel.VariationPoint#getVaryingSubjects <em>Varying Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Varying Subjects</em>'.
	 * @see UncertaintyVariationModel.VariationPoint#getVaryingSubjects()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_VaryingSubjects();

	/**
	 * Returns the meta object for the containment reference '{@link UncertaintyVariationModel.VariationPoint#getVariationDescription <em>Variation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variation Description</em>'.
	 * @see UncertaintyVariationModel.VariationPoint#getVariationDescription()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EReference getVariationPoint_VariationDescription();

	/**
	 * Returns the meta object for the attribute '{@link UncertaintyVariationModel.VariationPoint#getStateHandlerId <em>State Handler Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Handler Id</em>'.
	 * @see UncertaintyVariationModel.VariationPoint#getStateHandlerId()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EAttribute getVariationPoint_StateHandlerId();

	/**
	 * Returns the meta object for the attribute '{@link UncertaintyVariationModel.VariationPoint#getEntityName <em>Entity Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entity Name</em>'.
	 * @see UncertaintyVariationModel.VariationPoint#getEntityName()
	 * @see #getVariationPoint()
	 * @generated
	 */
	EAttribute getVariationPoint_EntityName();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.VariationDescription <em>Variation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variation Description</em>'.
	 * @see UncertaintyVariationModel.VariationDescription
	 * @generated
	 */
	EClass getVariationDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link UncertaintyVariationModel.VariationDescription#getTargetVariations <em>Target Variations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Variations</em>'.
	 * @see UncertaintyVariationModel.VariationDescription#getTargetVariations()
	 * @see #getVariationDescription()
	 * @generated
	 */
	EReference getVariationDescription_TargetVariations();

	/**
	 * Returns the meta object for the container reference '{@link UncertaintyVariationModel.VariationDescription#getVariationpoint <em>Variationpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variationpoint</em>'.
	 * @see UncertaintyVariationModel.VariationDescription#getVariationpoint()
	 * @see #getVariationDescription()
	 * @generated
	 */
	EReference getVariationDescription_Variationpoint();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see UncertaintyVariationModel.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the container reference '{@link UncertaintyVariationModel.Value#getVariationdescription <em>Variationdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variationdescription</em>'.
	 * @see UncertaintyVariationModel.Value#getVariationdescription()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_Variationdescription();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.PrimitiveValue <em>Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value</em>'.
	 * @see UncertaintyVariationModel.PrimitiveValue
	 * @generated
	 */
	EClass getPrimitiveValue();

	/**
	 * Returns the meta object for the reference '{@link UncertaintyVariationModel.PrimitiveValue#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link</em>'.
	 * @see UncertaintyVariationModel.PrimitiveValue#getLink()
	 * @see #getPrimitiveValue()
	 * @generated
	 */
	EReference getPrimitiveValue_Link();

	/**
	 * Returns the meta object for class '{@link UncertaintyVariationModel.ValueCollection <em>Value Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Collection</em>'.
	 * @see UncertaintyVariationModel.ValueCollection
	 * @generated
	 */
	EClass getValueCollection();

	/**
	 * Returns the meta object for the reference list '{@link UncertaintyVariationModel.ValueCollection#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see UncertaintyVariationModel.ValueCollection#getLinks()
	 * @see #getValueCollection()
	 * @generated
	 */
	EReference getValueCollection_Links();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UncertaintyVariationModelFactory getUncertaintyVariationModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.UncertaintyVariationsImpl <em>Uncertainty Variations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationsImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getUncertaintyVariations()
		 * @generated
		 */
		EClass UNCERTAINTY_VARIATIONS = eINSTANCE.getUncertaintyVariations();

		/**
		 * The meta object literal for the '<em><b>Variation Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNCERTAINTY_VARIATIONS__VARIATION_POINTS = eINSTANCE.getUncertaintyVariations_VariationPoints();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.VariationPointImpl <em>Variation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.VariationPointImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationPoint()
		 * @generated
		 */
		EClass VARIATION_POINT = eINSTANCE.getVariationPoint();

		/**
		 * The meta object literal for the '<em><b>Varying Subjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__VARYING_SUBJECTS = eINSTANCE.getVariationPoint_VaryingSubjects();

		/**
		 * The meta object literal for the '<em><b>Variation Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_POINT__VARIATION_DESCRIPTION = eINSTANCE.getVariationPoint_VariationDescription();

		/**
		 * The meta object literal for the '<em><b>State Handler Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_POINT__STATE_HANDLER_ID = eINSTANCE.getVariationPoint_StateHandlerId();

		/**
		 * The meta object literal for the '<em><b>Entity Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_POINT__ENTITY_NAME = eINSTANCE.getVariationPoint_EntityName();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.VariationDescriptionImpl <em>Variation Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.VariationDescriptionImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getVariationDescription()
		 * @generated
		 */
		EClass VARIATION_DESCRIPTION = eINSTANCE.getVariationDescription();

		/**
		 * The meta object literal for the '<em><b>Target Variations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_DESCRIPTION__TARGET_VARIATIONS = eINSTANCE.getVariationDescription_TargetVariations();

		/**
		 * The meta object literal for the '<em><b>Variationpoint</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_DESCRIPTION__VARIATIONPOINT = eINSTANCE.getVariationDescription_Variationpoint();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.ValueImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Variationdescription</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__VARIATIONDESCRIPTION = eINSTANCE.getValue_Variationdescription();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.PrimitiveValueImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getPrimitiveValue()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE = eINSTANCE.getPrimitiveValue();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VALUE__LINK = eINSTANCE.getPrimitiveValue_Link();

		/**
		 * The meta object literal for the '{@link UncertaintyVariationModel.impl.ValueCollectionImpl <em>Value Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UncertaintyVariationModel.impl.ValueCollectionImpl
		 * @see UncertaintyVariationModel.impl.UncertaintyVariationModelPackageImpl#getValueCollection()
		 * @generated
		 */
		EClass VALUE_COLLECTION = eINSTANCE.getValueCollection();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_COLLECTION__LINKS = eINSTANCE.getValueCollection_Links();

	}

} //UncertaintyVariationModelPackage
