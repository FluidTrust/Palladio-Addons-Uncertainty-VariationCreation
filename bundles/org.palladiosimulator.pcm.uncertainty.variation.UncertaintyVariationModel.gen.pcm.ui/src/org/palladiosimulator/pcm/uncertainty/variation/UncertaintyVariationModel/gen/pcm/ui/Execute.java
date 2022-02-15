package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;

public class Execute extends AbstractHandler implements IHandler {
    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IWorkbench wb = PlatformUI.getWorkbench();
        final IProgressService ps = wb.getProgressService();
        try {
            ps.run(true, true, new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor monitor) {
                    monitor.beginTask("generating variations", IProgressMonitor.UNKNOWN);
                    try {
                        final UncertaintyVariationModelGenPcm generator = new UncertaintyVariationModelGenPcm(URI
                            .createURI(
                                    "platform:/resource/FluidTrust-CaseStudy/models/port.uncertaintyvariationmodel"));
                        generator.generateVariations(monitor);
                    } catch (CoreException e) {
                    }
                    monitor.done();
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
