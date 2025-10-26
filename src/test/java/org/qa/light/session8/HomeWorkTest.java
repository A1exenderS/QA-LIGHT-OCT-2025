package org.qa.light.session8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.light.session8.alloTests.AlloMainPage;
import org.qa.light.session8.alloTests.StorePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

//TODO: Make allo.ua page object:
//TODO: - go to store page
//TODO: - execute search
//TODO: - print device name, price and screen type (use hover to see it)
// by index in search results index 1-3

public class HomeWorkTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkHoveringCards() {
        AlloMainPage mainPage = new AlloMainPage(driver);
        StorePage storePage = new StorePage(driver);

        mainPage.load();
        mainPage.executeSearch("IPhone 17");
        List<WebElement> searchResults = storePage.checkSearchResults();
        Assert.assertTrue(searchResults.size() >= 3, "We have some troubles with iPhones search");
        storePage.printHoveredCardData(searchResults);
    }

}
