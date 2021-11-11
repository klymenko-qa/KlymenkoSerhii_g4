package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends MainPage{

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement titleMyAccount;

    public String checkTitle() {
        return titleMyAccount.getText();
    }
}