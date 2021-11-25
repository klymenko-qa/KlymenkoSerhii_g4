package ui.pages.pagesSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MainPage {

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement login;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @Step("Input email create: {email}")
    public SignInPage inputEmailCreate(String email) {
        webElements.inputText(login, email);
        return this;
    }

    @Step("Click to button create")
    public SignInPage submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
        return this;
    }
}