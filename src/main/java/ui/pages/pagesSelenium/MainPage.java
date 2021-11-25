package ui.pages.pagesSelenium;

import io.qameta.allure.Step;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    /**
     * Method open url
     *
     * @param url
     * */
    @Step("Open url {url}")
    public void openUrl(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened: " + url);
        } catch (Exception e) {
            Assert.fail("Page can't opened: " + url);
        }
    }

    @Step("Check to SignIn page")
    public void clickToSignInPage() {
        signInLink.click();
    }
}