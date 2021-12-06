package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.statespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

class StatespaceItertator implements Iterator {
	public StatespaceItertator(Statespace statespace) {
		this.statespace = statespace;
		this.indices = new ArrayList<Integer>();
		for (int i = 0; i < this.statespace.getNumberOfDimensions(); ++i)
			this.indices.add(0);
	}

	@Override
	public boolean hasNext() {
		boolean result = true;
		for (int i = 0; i < this.indices.size(); ++i) {
			result = result && (this.indices.get(i) < this.statespace.getSizeOfDimension(i));
		}

		return result;
	}

	@Override
	public void next() {
		if (!this.hasNext())
			return;
		
		for(int i = 0; i < this.indices.size(); ++i) {
			int currIdx = this.indices.get(i);
			++currIdx;
			boolean hasNext = (i + 1) < this.statespace.getNumberOfDimensions();
			
			if (currIdx == this.statespace.getSizeOfDimension(i) && hasNext) {
				this.indices.set(i, 0);
			} else {
				this.indices.set(i, currIdx);
				break;
			}
		}
	}

	@Override
	public void patchModels(Map<String, List<EObject>> models) {
		if (!this.hasNext())
			return;
		
		for (int i = 0; i < this.indices.size(); ++i) {
			this.statespace.patchModelsWith(models, i, this.indices.get(i));
		}		
	}
	
	private Statespace statespace;
	private List<Integer> indices;
}
