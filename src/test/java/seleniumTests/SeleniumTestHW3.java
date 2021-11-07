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

public class SeleniumTestHW3 {

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
        webDriver.get("https://en.wikipedia.org/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Close browser");
    }

    @Test
    public void wikipediaTest() {
        logger.info("Open Wikipedia main page");
        Assert.assertEquals(
                "Welcome to Wikipedia,",
                webDriver.findElement(By.xpath("//div[@id='mp-welcome']")).getText());

        webDriver.findElement(By.xpath("//a[@title='Portal:Geography']")).click();
        logger.info("Open link: https://en.wikipedia.org/wiki/Portal:Geography");
        Assert.assertEquals(
                "The Geography Portal",
                webDriver.findElement(By.xpath("//span[@id='The_Geography_Portal']")).getText());
        webDriver.navigate().back();

        webDriver.findElement(By.xpath("//a[@title='Portal:History']")).click();
        logger.info("Open link: https://en.wikipedia.org/wiki/Portal:History");
        Assert.assertEquals(
                "The History Portal",
                webDriver.findElement(By.xpath("//span[@id='The_History_Portal']")).getText());
        webDriver.navigate().back();

        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@id='mp-portals']/li"));
        logger.info("Number of elements: " + elements.size());
        for (int i = 0; i < elements.size(); i++) {
            logger.info("Values: " + elements.get(i).getText());
        }
    }
}
