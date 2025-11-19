package org.qa.light.session12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.light.session12.alloPages.AlloMainPage;
import org.qa.light.session12.alloPages.StorePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class PhonesToDBTest {

    private WebDriver driver;
    private Connection conn;
    private Statement stmt;

    @BeforeSuite
    public void setUp() throws SQLException {
        driver = new ChromeDriver();
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        stmt = conn.createStatement();
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        driver.quit();
        conn.close();
    }

    @Test
    public void checkAndStoreToDBHoveredCards() throws SQLException {
        AlloMainPage mainPage = new AlloMainPage(driver);
        StorePage storePage = new StorePage(driver);

        mainPage.load();
        mainPage.executeSearch("Samsung");
        List<WebElement> searchResults = storePage.checkSearchResults();
        Assert.assertTrue(searchResults.size() >= 3, "We have some troubles with iPhones search");
        List<HoveredCardItem> hoveredCardItems = storePage.printHoveredCardData(searchResults);
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO Phones (DeviceName, DevicePrice, DeviceScreenSize) VALUES (?,?,?)"
        );

        for (HoveredCardItem hoveredCardItem : hoveredCardItems) {
            preparedStatement.setString(1, hoveredCardItem.getDeviceName());
            preparedStatement.setString(2, hoveredCardItem.getDevicePrice());
            preparedStatement.setString(3, hoveredCardItem.getDeviceScreenType());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to save in DB: " + hoveredCardItem);
            }
        }
    }
}


