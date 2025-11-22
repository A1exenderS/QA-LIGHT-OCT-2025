package org.qa.light.session13;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class,
                testStepFinished -> {
                    System.out.println(">>>>>>>>>>>TestStepStarted<<<<<<<<<<<<<<<<<");
                });
    }
}
