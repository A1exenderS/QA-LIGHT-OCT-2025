package org.qa.light.session8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: Make allo.ua page object:
//TODO: - go to store page
//TODO: - execute search
//TODO: - print device name, price and screen type (use hover to see it)
// by index in search results index 1-3


public class WebTests {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

//    @Test
//    public void shadowRoot() {
//        driver.get("https://developer.mozilla.org/en-US/play");
//        WebElement element = driver.findElement(By.tagName("mdn-playground"));
//        SearchContext searchContext = element.getShadowRoot();
//        List<WebElement> headers = searchContext.findElements(By.tagName("h1"));
//        System.out.println(headers.size());
//    }


    @Test
    public void iFrameTest() {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        List<WebElement> cookies = driver.findElements(By.id("accept-choices"));
        if (!cookies.isEmpty()) {
            cookies.get(0).click();
        }
        WebElement iFrameOuter = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iFrameOuter);

        WebElement header2 = driver.findElement(By.tagName("h2"));
        System.out.println(header2.getText());

        WebElement iFrameInner = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameInner);

        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText());

        driver.switchTo().defaultContent();
    }

    @Test
    public void session8() {
        driver.get("https://www.cloudflare.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler"))
        );
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//            Actions actions = new Actions(driver);
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

//            DevTools devTools = (DevTools) driver;
//            devTools.send(Performance.enable(Optional.empty()));
//            List<Metric> metricList = devTools.send(Performance.getMetrics());
    }

    @Test
    public void session8CLoudFlare1() throws InterruptedException {
        CloudFlarePage page = new CloudFlarePage(driver);
        page.load();
        page.cookies();
        page.upperMenuHover("Platform");
        System.out.println("done");
    }

}
