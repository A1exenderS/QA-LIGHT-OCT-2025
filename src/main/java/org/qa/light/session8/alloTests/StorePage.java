package org.qa.light.session8.alloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {
    private final static String URL = "";
    private final WebDriver driver;

    public By productCard = By.xpath("//div[@class='product-card']");

    public StorePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> checkSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCard));
        return driver.findElements(productCard);
    }

    public void printHoveredCardData(List<WebElement> searchResults) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));

        for (int i = 0; i < 3; i++) {

            By itemName = By.xpath("(//a[@class='product-card__title'])[" + (i + 1) + "]");
            By itemPrice = By.xpath("(//div[@class='v-pb__cur discount']/span[@class='sum'])[" + (i + 1) + "]");
            By itemScreenType = By.xpath(
                    "(//div[@class='product-card__detail']/dl/dt[contains(text(), 'Тип екрану')]/following-sibling::dd)[" + (i + 1) + "]");

            WebElement searchItem = searchResults.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(searchItem);
            actions.perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(itemScreenType));
            String productName = driver.findElement(itemName).getText();
            String productPrice = driver.findElement(itemPrice).getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(itemScreenType));
            String productScreenType = driver.findElement(itemScreenType).getText();

            System.out.println(
                    "Phone " + productName + ", costs - " + productPrice + ". It has " + productScreenType + " screen.");
        }
    }

}
