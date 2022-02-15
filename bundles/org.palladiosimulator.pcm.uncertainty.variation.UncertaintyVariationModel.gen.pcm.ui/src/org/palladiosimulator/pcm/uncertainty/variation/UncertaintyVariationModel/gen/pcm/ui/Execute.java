package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

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
                    ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
                        .getActivePage()
                        .getSelection();
                    if (selection != null & selection instanceof IStructuredSelection) {
                        IStructuredSelection strucSelection = (IStructuredSelection) selection;
                        for (@SuppressWarnings("unchecked")
                        Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
                            Object currElement = iterator.next();
                            if (currElement instanceof IFile) {
                                IFile currFile = (IFile) currElement;
                                URI currFileURI = URI.createURI("platform:/resource")
                                    .appendSegment(currFile.getProject()
                                        .getName())
                                    .appendSegments(currFile.getProjectRelativePath()
                                        .segments());

                                try {
                                    final UncertaintyVariationModelGenPcm generator = new UncertaintyVariationModelGenPcm(
                                            currFileURI);
                                    generator.generateVariations(monitor);
                                } catch (CoreException e) {
                                }
                            }
                        }
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
