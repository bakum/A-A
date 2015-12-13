package ua.bakum.aa.view;

import java.util.List;

import oracle.adf.controller.v2.context.LifecycleContext;
import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.jbo.JboException;

public class AAListener implements PagePhaseListener {
    public AAListener() {
        super();
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
        }
    }

    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
            processErrors(pagePhaseEvent.getLifecycleContext());
        }
    }
    
    private void processErrors(LifecycleContext ctx) {
        DCBindingContainer bc = (DCBindingContainer) ctx.getBindingContainer();
        String error_message;
        if (bc != null) {
            List<Exception> exceptions = bc.getExceptionsList();
            if (exceptions != null) {
                for (Exception exception : exceptions) {
                    System.out.println("AAListener processErrors exception " + exception.getMessage());
                    if (exception instanceof JboException) {
                        error_message = exception.getMessage();
                        //if (error_message != null && error_message.indexOf("JBO-27010") > -1) {

                        //} else {
                            bc.ignoreExceptionForDisplay((JboException) exception);
                        //}
                    }
                }
            }
        }

    }
}
