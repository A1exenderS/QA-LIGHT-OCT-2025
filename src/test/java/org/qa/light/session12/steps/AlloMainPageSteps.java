package org.qa.light.session12.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.qa.light.session12.alloPages.AlloMainPage;

public class AlloMainPageSteps {

    public static AlloMainPage alloMainPage;

    @Given("the user opens the Allo main page")
    public void loadPage() {
        alloMainPage.load();
    }

    @When("the user searches for {string}")
    public void executeSearch(String searchData) {
        alloMainPage.executeSearch(searchData);
    }
}
