package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationAlternativePage extends MainPage{

    public RegistrationAlternativePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement login;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//h1[@class='page-heading']")
    public WebElement titleCreateAnAccount;

    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    public WebElement titleYPI;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstNameField;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastNameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(xpath = "//h3[contains(text(),'Your address')]")
    public WebElement titleYourAddress;

    @FindBy(id = "firstname")
    public WebElement fistNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]/input[@type='text']")
    public WebElement streetField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateSelect;

    @FindBy(id = "postcode")
    public WebElement postCodeField;

    @FindBy(id = "id_country")
    public WebElement countryField;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy(id = "alias")
    public WebElement aliasField;

    @FindBy(id = "submitAccount")
    public WebElement submitButtonAccount;

    /**
     * Method click to SingIn page
     * */
    public RegistrationAlternativePage openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    public RegistrationAlternativePage inputEmailCreate(String email) {
        webElements.inputText(login, email);
        return this;
    }

    public RegistrationAlternativePage submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
        return this;
    }

    public RegistrationAlternativePage inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstNameField, firstName);
        return this;

    }

    public RegistrationAlternativePage inputCustomerLN(String lastName) {
        webElements.inputText(customerLastNameField, lastName);
        return this;

    }

    public RegistrationAlternativePage inputEmail(String email) {
        webElements.inputText(emailField, email);
        return this;
    }

    public RegistrationAlternativePage inputPassword(String password) {
        webElements.inputText(passwordField, password);
        return this;
    }

    public RegistrationAlternativePage inputFirstName(String fistName) {
        webElements.inputText(fistNameField, fistName);
        return this;
    }

    public RegistrationAlternativePage inputLastName(String lastName) {
        webElements.inputText(lastNameField, lastName);
        return this;
    }

    public RegistrationAlternativePage inputStreet(String street) {
        webElements.inputText(streetField, street);
        return this;
    }

    public RegistrationAlternativePage inputCity(String city) {
        webElements.inputText(cityField, city);
        return this;
    }

    public RegistrationAlternativePage selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
        return this;
    }

    public RegistrationAlternativePage inputPostCode(String postCode) {
        webElements.inputText(postCodeField, postCode);
        return this;
    }

    public RegistrationAlternativePage inputMobilePhone(String phone) {
        webElements.inputText(phoneMobile, phone);
        return this;
    }

    public RegistrationAlternativePage inputAliasAddress(String alias) {
        webElements.inputText(aliasField, alias);
        return this;
    }

    public RegistrationAlternativePage clickToButtonSubmitAccount() {
        webElements.clickOnElement(submitButtonAccount);
        return this;
    }
}
