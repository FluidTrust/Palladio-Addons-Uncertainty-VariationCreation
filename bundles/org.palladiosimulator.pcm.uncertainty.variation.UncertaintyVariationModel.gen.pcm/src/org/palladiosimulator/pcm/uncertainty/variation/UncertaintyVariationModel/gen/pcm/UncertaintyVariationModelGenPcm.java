package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Iterator;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.Statespace;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace.statehandler.pcm.AllocationStateHandler;

import UncertaintyVariationModel.UncertaintyVariations;

public class UncertaintyVariationModelGenPcm {
	public UncertaintyVariationModelGenPcm(String baseUri) {
		this.scenarioManager = new ScenarioManager(
				baseUri, 
				Arrays.asList(AllocationStateHandler.MODEL_TYPE)
		);
		this.variationManager = new VariationManager(baseUri);
	}
	
	public void generateVariations(IProgressMonitor progressMonitor) {
		Statespace statespace = new Statespace((UncertaintyVariations) variationManager.loadUncertaintyVariantModel("port"));

		
		//Iterator
		progressMonitor.beginTask("creating variations", IProgressMonitor.UNKNOWN);
		int i = 0;
		for (Iterator it = statespace.iterator(); it.hasNext(); it.next())
		{
            try {
				scenarioManager.createCurrVariant(i, progressMonitor);
				Map<String, List<EObject>> models = scenarioManager.loadCurrVariantModels();
				it.patchModels(models);
				scenarioManager.storeCurrVariantModels(models);
				++i;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		progressMonitor.done();
	}
	
	private ScenarioManager scenarioManager;
	private VariationManager variationManager;
}
