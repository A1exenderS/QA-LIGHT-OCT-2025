package org.qa.light.session12.alloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlloMainPage {

    private final static String URL = "https://allo.ua/";
    private final WebDriver driver;

    public By searchInput = By.xpath("//input[@name='search']");
    public By searchButton = By.xpath("//button[@class='search-form__submit-button']");

    public AlloMainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public void load() {
        driver.get(URL);
    }

    public void executeSearch(String searchValue) {

        driver.findElement(searchInput).sendKeys(searchValue);
        driver.findElement(searchButton).click();
    }
}
