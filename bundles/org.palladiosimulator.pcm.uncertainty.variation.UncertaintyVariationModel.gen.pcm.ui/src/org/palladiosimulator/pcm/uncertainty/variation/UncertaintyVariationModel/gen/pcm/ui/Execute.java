package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Execute extends AbstractHandler implements IHandler {
    private static final Logger LOGGER = LoggerFactory
        .getLogger("org.palladiosimulator.pcm.uncertainty.variation.ui.logger");

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IWorkbench wb = PlatformUI.getWorkbench();
        final IProgressService ps = wb.getProgressService();
        try {
            ps.run(true, true, new IRunnableWithProgress() {
                @Override
                public void run(final IProgressMonitor monitor) {
                    monitor.beginTask("generating variations", IProgressMonitor.UNKNOWN);
                    final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
                        .getActivePage()
                        .getSelection();
                    if (selection != null & selection instanceof IStructuredSelection) {
                        final IStructuredSelection strucSelection = (IStructuredSelection) selection;
                        for (final Object currElement : strucSelection) {
                            if (currElement instanceof IFile) {
                                final IFile currFile = (IFile) currElement;
                                final URI currFileURI = URI.createURI("platform:/resource")
                                    .appendSegment(currFile.getProject()
                                        .getName())
                                    .appendSegments(currFile.getProjectRelativePath()
                                        .segments());

                                try {
                                    final UncertaintyVariationModelGenPcm generator = new UncertaintyVariationModelGenPcm(
                                            currFileURI);
                                    generator.generateVariations(monitor);
                                } catch (final CoreException e) {
                                    LOGGER.error("result directory cannot be created", e);
                                } catch (final IllegalArgumentException e) {
                                    LOGGER.error("uri of uncertainty variation model is illformed", e);
                                }
                            }
                        }
                    }
                    monitor.done();
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            LOGGER.error("generation interrupted or call to generation failed", e);
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
