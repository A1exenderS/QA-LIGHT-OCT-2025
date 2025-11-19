package org.qa.light.session12.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.qa.light.session12.HoveredCardItem;
import org.qa.light.session12.alloPages.StorePage;
import org.testng.Assert;

import java.util.List;

public class AlloStorePageSteps {

    public static StorePage alloStorePage;

    @Then("at least 3 search results should be displayed")
    public void validateSearchResults() {
        List<WebElement> searchResults = alloStorePage.checkSearchResults();
        Assert.assertTrue(searchResults.size() >= 3, "We have some troubles with iPhones search");
    }

    @When("the user hovers the first 3 product cards")
    public void hoverAndGetCardsData(List<WebElement> searchResults) {
        List<HoveredCardItem> hoveredCardItems = alloStorePage.printHoveredCardData(searchResults);
    }
}
