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

public class SeleniumTestHW4 {

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
        webDriver.get("https://finance.i.ua/converter/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Close browser");
    }

    @Test
    public void converterTest() {
        logger.info("Open online Converter");
        Assert.assertEquals("Incorrect URL", webDriver.getCurrentUrl(), "https://finance.i.ua/converter/");
        logger.info("Verify current URL");
        Assert.assertEquals(
                "Конвертер валют онлайн. Конвертер валют Украины онлайн по курсу НБУ",
                webDriver.getTitle());

        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@id='form_converter_result']//span[@class='_description']"));
        logger.info("Number of elements: " + elements.size());
        for (int i = 0; i < elements.size(); i++) {
            logger.info("Values: " + elements.get(i).getText());
        }

        List<WebElement> bankElements = webDriver.findElements(By.xpath("//select[@id='converter_bank']/option"));
        logger.info("Number of converter banks: " + bankElements.size());
        Assert.assertEquals(bankElements.size(), 52);

        int amount = 456;
        webDriver.findElement(By.cssSelector("#converter_currency")).click();
        webDriver.findElement(By.cssSelector("#converter_currency > option:nth-child(2)")).click();
        logger.info("Choose EURO value");
        webDriver.findElement(By.cssSelector("#currency_amount")).sendKeys(String.valueOf(amount));
        logger.info("Input amount");

        String rateUah = webDriver.findElement(By.xpath("//p[@id='UAH']//input[@id='currency_rate']"))
                .getAttribute("value");
        double rateUahDouble = Double.parseDouble(rateUah);
        double sum = amount * rateUahDouble;
        String expectedExchangeUah = String.valueOf(sum).substring(0, 8);
        logger.info("Expected exchange result");
        String actualExchangeUah = webDriver.findElement(By.xpath("//p[@id='UAH']//input[@id='currency_exchange']"))
                .getAttribute("value").replaceAll(" ", "");
        Assert.assertEquals(expectedExchangeUah, actualExchangeUah);

        webDriver.findElement(By.xpath("//a[text()='Черный рынок']")).click();
        logger.info("Open 'Черный рынок'");
        Assert.assertEquals(
                "Черный рынок валют", webDriver.findElement(By.xpath("//h1")).getText());
    }
}