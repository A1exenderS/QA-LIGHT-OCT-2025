package org.qa.light.session12.steps;

import io.cucumber.java.en.Given;
import org.qa.light.session8.CloudFlarePage;

public class WebSteps {
    public static CloudFlarePage cloudFlarePage;

    @Given("Cloud flare step")
    public void cloudFlareStep() {
        cloudFlarePage.load();
    }
}
