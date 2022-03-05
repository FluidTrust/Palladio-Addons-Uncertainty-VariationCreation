# Palladio-Addons-Uncertainty-VariationCreation

## Introduction
This project extends the Palladio Component Model as well as the models of the Fluid Trust Project with the functionality to automatically generate parallely existing variants from these basis models. This generation is controlled through the Uncertainty Variation Model and the state handlers. The Uncertainty Variation Model contains the variation points that affect the source models with their possible values. The state handlers realisize the transformation of the source models to the different variants based on the Uncertainty Variation Models description. 

## Requirments
The features Uncertainty Variation Creation and Uncertainty Variation PCM Creation require the following Packages:
* Palladio Commons Identifier from the Location https://updatesite.palladio-simulator.com/palladio-build-updatesite/nightly/
* Palladio Component Model from the Location https://updatesite.palladio-simulator.com/palladio-build-updatesite/nightly/
* Palladio Workflow Engine Core from the Location https://updatesite.palladio-simulator.com/palladio-build-updatesite/nightly/
* Emf Edit Utils from the Location https://updatesite.mdsd.tools/library-emfeditutils/releases/latest/
* EMF - Eclipse Modeling Framework SDK from the Location http://download.eclipse.org/releases/2021-12
* SLF4J API Module from the Location https://download.eclipse.org/tools/orbit/downloads/drops/R20211213173813/repository
The feature Uncertainty Variation Dataflow Creation requires additionally the following Packages:
* Data Flow Confidentiality Tree Editors from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* Data Flow Confidentiality Meta Models from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* PCM Data Flow Confidentiality Tree Editor from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* PCM Data Flow Confidentiality Model from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* Data Dictionary Tree Editor from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* Data Dictionary Meta Model from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* Characterized Data Dictionary DSL from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
* PCM Data Flow Confidentiality Dictionary DSL from the Location https://updatesite.palladio-simulator.com/fluidtrust/fluidtrust-build-updatesite/nightly/
The building and testing requires additionally the following Packages:
* MWE2 from the Location http://download.eclipse.org/releases/2021-12
* Uml2 from the Location http://download.eclipse.org/releases/2021-12
* Xtext from the Location http://download.eclipse.org/releases/2021-12
* MDSD.tools EcoreWorkflow MWE2 Library from the Location https://updatesite.mdsd.tools/ecore-workflow/releases/latest/
* MDSD.tools EcoreWorkflow MWE2 Library for Xtext from the Location https://updatesite.mdsd.tools/ecore-workflow/releases/latest/
* JUnit5 Jupiter (already installed in Eclipse)

## Usage
The following subsections will describe the generation of a new Uncertainty Variation project as well as the generation of variation through an existing Uncertainty Variation project.
### New Uncertainty Variation Project

1. Create a new Modeling project
2. Create a subfolder in this project, which will later contain the sources
  1. Create a new Uncertainty Variation Model inside this subfolder through Example EMF Model Creation Wizards Uncertainty Variation Model with Uncertainty Variations as Model Object
![EMF Model Creation Wizard Section of the new wizards](doc/img/UncertaintyVariationModel-Creation-WizardSelectionA.png "EMF Model Creation Wizard Section of the new Wizards")
![Uncertainty Variation Model Wizard inside of the EMF Model Creation Wizard Section](doc/img/UncertaintyVariationModel-Creation-WizardSelectionB.png "Uncertainty Variation Model Wizard inside of the EMF Model Creation Wizard Section")
![Selecting of the Root Element inside of the Creation Wizard](doc/img/UncertaintyVariationModel-Creation-RootElementSelcection.png "Selecting of the Root Element inside of the Creation Wizard")
  2. Create a subfolder inside this subfolder, which will later contain the orginal Palladio Component Model
    1. Create a new Palladio Components Model inside of the current folder
    2. Optionally create a new Data Confidential Model inside of the current folder
  3. Configure the Uncertainty Variation Model
    1. Add required resources of the Palladio Component Model or Data Confidential Model
![Opening Resource Loader for an open Uncertainty Variation Model](doc/img/UncertaintyVariationModel-LoadResource.png "Opening Resource Loader for an open Uncertainty Variation Model")
    2. Add a new variation point to the Root Element
![Adding a new variation point](doc/img/UncertaintyVariationModel-Create-NewVariationPoint.png "Adding a new variation point")
       1. Set the entity name of this variation point
       2. Set the state handler of this variation point
![Setting of a state handler](doc/img/UncertaintyVariationModel-VariationPoint-SetStateHandler.png "Setting of a state handler")
           - org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.AllocationStateHandler: (AllocationContext, ResourceContainer)
           - org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.AssemblyStateHandler: (AssemblyContext, RepositoryComponent)
           - org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.BranchStateHandler: (Branch, BranchAction)
           - org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.CharacteristicsStateHandler: (EnumCharacteristic, Literal)
       2. Set the varying subjects, which are the elements that will be modified during the generation, to this variation point
![Setting of varying subjects](doc/img/UncertaintyVariationModel-VariationPoint-SetVaryingSubjecs.png "Setting of varying subjects")
       3. Add a variation description to this variation point in the case the state handler operates on external data
![Adding a variation description to the variation point](doc/img/UncertaintyVariationModel-Create-NewVariationDescription.png "Adding a variation description to the variation point")
         1. Add a primitive value or value collection (if more then one element can simultaneously exist) to the variation description
![Adding a primitive value to the variation description](doc/img/UncertaintyVariationModel-Create-NewPrimitiveValue.png "Adding a primitive value to the variation description")
	   1. Set the link or links (in case of a value collection), which are the elements that vary, to this primitive value or  value collection
         2. Repeat with the next value until all required values have been added to the variation description
    2. Repeat with the next resource until all required variation points have been added 

### Variant Generation with UI

1. Open view Project Explorer
2. Open the desired Uncertainty Variation Project
3. Right click on the Uncertainty Variation Model of this Project
![Selection of an Uncertainty Variation Model before accessing the context menu](doc/img/UncertaintyVariationModel-ModelSelection.png "Selection of an Uncertainty Variation Model before accessing the context menu")
4. Select Generate Uncertainty Variations to run the generation of the different variants based of the Uncertainty Variation Model. The result of the generation can be found inside this projects autogenerated folder named  scenarios.
![Selecting Generate Uncertainty Variations in the Context Menu](doc/img/UncertaintyVariationModel-ContextMenu.png "Selecting Generate Uncertainty Variations in the Context Menu")

### Variant Generation with Workflow

The Package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.workflow contains the UncertaintyWorkflowJob that integrates the variant generation into the [Palladio Workflow Engine](https://sdqweb.ipd.kit.edu/wiki/Palladio_Workflow_Engine). This job receives as argument the uri of the Uncertainty Variation Model that shall be used for the generation.

##Development

### New State Handler

### Uncertainty Variation Model
![Uncertainty Variation Model](doc/img/UncertaintyVariationModelDiagram.png "Uncertainty Variation Model")
OK Image




