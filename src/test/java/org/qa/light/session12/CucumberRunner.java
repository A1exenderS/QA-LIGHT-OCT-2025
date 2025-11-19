package org.qa.light.session12;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.light.session12.alloPages.AlloMainPage;
import org.qa.light.session12.alloPages.StorePage;
import org.qa.light.session12.steps.*;
import org.qa.light.session8.CloudFlarePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: homework for session 11 in cucumber

@CucumberOptions(
        glue = "org.qa.light.session12.steps",
        features = "src/test/resources/features/demo",
        plugin = {"pretty"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    private Connection conn;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        driver = new ChromeDriver();
        WebSteps.cloudFlarePage = new CloudFlarePage(driver);
        AlloMainPageSteps.alloMainPage = new AlloMainPage(driver);
        AlloStorePageSteps.alloStorePage = new StorePage(driver);

        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        DBSteps.conn = conn;
        DBStepsV2.conn = conn;
        AlloDBSteps.conn = conn;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        driver.quit();
        conn.close();
    }
}
