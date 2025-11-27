package org.qa.light.session13.steps.elements;

import org.openqa.selenium.WebDriver;

public class GeneralPageObject {

    private final WebDriver driver;

    public GeneralPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSomething(ILocatable locatable) {
        driver.findElement(locatable.getLocator()).click();
    }
}
