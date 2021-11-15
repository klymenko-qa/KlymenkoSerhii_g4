package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage{

    public RegistrationPage(WebDriver webDriver) {
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

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMessage;

    /**
     * Method click to SingIn page
     * */
    public void openSignInPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    public void inputEmailCreate(String email) {
        webElements.inputText(login, email);
    }

    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    public void inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstNameField, firstName);
    }

    public void inputCustomerLN(String lastName) {
        webElements.inputText(customerLastNameField, lastName);
    }

    public void inputEmail(String email) {
        webElements.inputText(emailField, email);
    }

    public void inputPassword(String password) {
        webElements.inputText(passwordField, password);
    }

    public void inputFirstName(String fistName) {
        webElements.inputText(fistNameField, fistName);
    }

    public void inputLastName(String lastName) {
        webElements.inputText(lastNameField, lastName);
    }

    public void inputStreet(String street) {
        webElements.inputText(streetField, street);
    }

    public void inputCity(String city) {
        webElements.inputText(cityField, city);
    }

    public void selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
    }

    public void inputPostCode(String postCode) {
        webElements.inputText(postCodeField, postCode);
    }

    public void inputMobilePhone(String phone) {
        webElements.inputText(phoneMobile, phone);
    }

    public void inputAliasAddress(String alias) {
        webElements.inputText(aliasField, alias);
    }

    public void clickToButtonSubmitAccount() {
        webElements.clickOnElement(submitButtonAccount);
    }

    public String checkErrorMessage() {
        return errorMessage.getText();
    }
}