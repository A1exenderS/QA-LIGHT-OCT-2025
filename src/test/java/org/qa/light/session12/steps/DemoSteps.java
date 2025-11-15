package org.qa.light.session12.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps {

    @Given("I request 3 random people from API")
    public void iRequest3RandomPeopleFromAPI() {
        System.out.println("I request 3 random people from API");
    }

    @When("I store those people in DB")
    public void iStoreThosePeopleInDB() {
        System.out.println("I store those people in DB");
    }

    @Then("Then DB has 3 more entries")
    public void thenDBHas3MoreEntries() {
        System.out.println("Then DB has 3 more entries");
    }
}
