package ui.pages.pagesSelenide;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public final SelenideElement
            signInLink = $x("//a[@class='login']"),
            column = $x("//div[@id='center_column']");

    public final ElementsCollection products = $$("#homefeatured li div div h5 a");

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

    @Step("Get product: {text}")
    public MainPage getProduct(String text) {
        if (column.exists()) {
            // strict verification
            products.shouldHave(CollectionCondition.itemWithText(text));
            // non strict verification
            products.filter(Condition.text(text)).shouldHave(CollectionCondition.sizeGreaterThan(0));
        } else {
            products.shouldHave(CollectionCondition.size(0));
        }
        return this;
    }

    @Step("Click to product: {text}")
    public MainPage clickToProduct(String text) {
        products.findBy(Condition.exactText(text)).click();
        return this;
    }
}