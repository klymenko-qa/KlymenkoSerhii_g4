package ui.pages.pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    public  final SelenideElement
            login = $x("//input[@id='email_create']"),
            submitButtonCreate = $(By.id("SubmitCreate"));

    @Step("Input email create: {email}")
    public SignInPage inputEmailCreate(String email) {
        login.setValue(email);
        return this;
    }

    @Step("Click to button create")
    public SignInPage submitButtonCreate() {
        submitButtonCreate.click();
        return this;
    }
}