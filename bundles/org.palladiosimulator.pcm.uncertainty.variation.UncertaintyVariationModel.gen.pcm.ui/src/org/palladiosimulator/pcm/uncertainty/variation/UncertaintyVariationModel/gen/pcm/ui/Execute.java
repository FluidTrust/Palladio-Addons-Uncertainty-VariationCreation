package org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.palladiosimulator.pcm.uncertainty.variation.UncertaintyVariationModel.gen.pcm.UncertaintyVariationModelGenPcm;

public class Execute implements IHandler {
    @Override
    public void addHandlerListener(final IHandlerListener handlerListener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final UncertaintyVariationModelGenPcm generator = new UncertaintyVariationModelGenPcm(
                "platform:/resource/FluidTrust-CaseStudy");
        generator.generateVariations(new NullProgressMonitor());
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isHandled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeHandlerListener(final IHandlerListener handlerListener) {
        // TODO Auto-generated method stub

    }

}
