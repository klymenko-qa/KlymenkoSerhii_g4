package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {

    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method input text
     *
     * @param element
     * @param text
     * */
    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");
        } catch (Exception e) {
            Assert.fail("Can't work with element: " + element);
        }
    }

    /**
     * Method click element button
     *
     * @param element
     * */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked: " + element);
        } catch (Exception e) {
            Assert.fail("Can't work with element: " + element);
        }
    }
}