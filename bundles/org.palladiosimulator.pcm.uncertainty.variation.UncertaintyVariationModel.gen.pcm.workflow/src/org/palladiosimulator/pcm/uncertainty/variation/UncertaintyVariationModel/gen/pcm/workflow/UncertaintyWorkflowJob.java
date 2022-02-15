package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.workflow;

import java.util.Objects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

public class UncertaintyWorkflowJob extends SequentialJob {

    private URI uri;

    public UncertaintyWorkflowJob(URI uri) {
        Objects.nonNull(uri);
        this.uri = uri;
    }

    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        try {
            var generation = new UncertaintyVariationModelGenPcm(uri);
            generation.generateVariations(monitor);
        } catch (CoreException e) {
        }
    }

}
