package org.qa.light.session7;

//TODO: write test that will to go allo.ua, search for iphone 17
//TODO *: Assert that search has at least 3 results

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWork {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test() {

        driver.get("https://allo.ua/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));

        searchInput.sendKeys("iphone 17");
        searchButton.click();

        List<WebElement> marketItems = driver.findElements(By.xpath("//div[@class=\"product-card\"]"));
        Assert.assertTrue(marketItems.size() >= 3, "We have some troubles with iPhones search");

    }

    @AfterTest
    public void afterEach() {
        driver.quit();
    }
}
