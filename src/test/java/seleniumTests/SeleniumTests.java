package seleniumTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    WebDriver webDriver;
    Logger logger;

    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        File fileChrome = new File("drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromedriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.selenium.dev/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Close browser");
    }

    @Test
    public void seleniumTest() {
        webDriver.findElement(By.xpath("//a[@href='/downloads']//span")).click();
        logger.info("Open link: https://www.selenium.dev/downloads/");
        Assert.assertEquals(
                "Downloads",
                webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
        webDriver.findElement(By.xpath("//a[@href='/projects']")).click();
        logger.info("Open link: https://www.selenium.dev/projects/");
        Assert.assertEquals(
                "Selenium Projects",
                webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
        webDriver.findElement(By.xpath("//a[@href='/support']")).click();
        logger.info("Open link: https://www.selenium.dev/support/");
        Assert.assertEquals(
                "Getting Help",
                webDriver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id='main_navbar']/ul/li/a/span"));
        logger.info("Number of elements: " + elements.size());
        for (int i = 0; i < elements.size(); i++) {
            logger.info("Values: " + elements.get(i).getText());
        }
    }

    @Test
    public void seleniumTest_2() {
        webDriver.findElement(By.cssSelector("#main_navbar ul li:nth-child(3) span:nth-child(1)")).click();
        logger.info("Open link: https://www.selenium.dev/downloads/");
        Assert.assertEquals(
                "Downloads",
                webDriver.findElement(By.cssSelector("h1")).getText());
        webDriver.findElement(By.cssSelector(".nav-link[href='/projects']")).click();
        logger.info("Open link: https://www.selenium.dev/projects/");
        Assert.assertEquals(
                "Selenium Projects",
                webDriver.findElement(By.cssSelector(".text-center>h1")).getText());
    }
}