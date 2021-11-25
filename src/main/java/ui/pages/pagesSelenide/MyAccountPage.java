package ui.pages.pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {

    public final SelenideElement
            titleMyAccount = $x("//h1[@class='page-heading']"),
            accountBtn = $x("//a[@class='account']/span");


    @Step("Get account user name")
    public String getAccountName() {
        return accountBtn.getText();
    }
}