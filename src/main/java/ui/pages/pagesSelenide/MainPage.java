package ui.pages.pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public final SelenideElement
            signInLink = $x("//a[@class='login']");

    @Step("Open url: {url}")
    public MainPage openUrl(String url) {
        Selenide.open(url);
        return this;
    }

    @Step("Check to SignIn page")
    public MainPage clickToSignInPage() {
        signInLink.shouldBe(Condition.visible).click();
        return this;
    }
}