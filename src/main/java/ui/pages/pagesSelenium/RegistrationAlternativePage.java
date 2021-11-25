package ui.pages.pagesSelenium;

import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationAlternativePage extends MainPage {

    public RegistrationAlternativePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='radio-inline'][1]")
    public WebElement genderMr;

    @FindBy(xpath = "//div[@class='radio-inline'][2]")
    public WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstNameField;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastNameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement daysInDropDown;

    @FindBy(id = "months")
    public WebElement monthsInDropDown;

    @FindBy(id = "years")
    public WebElement yearsInDropDown;

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

    @Step("Select gender: {gender}")
    public RegistrationAlternativePage selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
        return this;
    }

    @Step("Input customer first name; {firstName}")
    public RegistrationAlternativePage inputCustomerFN(String firstName) {
        webElements.inputText(customerFirstNameField, firstName);
        return this;
    }

    @Step("Input customer last name; {lastName}")
    public RegistrationAlternativePage inputCustomerLN(String lastName) {
        webElements.inputText(customerLastNameField, lastName);
        return this;
    }

    @Step("Input email: {email}")
    public RegistrationAlternativePage inputEmail(String email) {
        webElements.inputText(emailField, email);
        return this;
    }

    @Step("Input password: {password}")
    public RegistrationAlternativePage inputPassword(String password) {
        webElements.inputText(passwordField, password);
        return this;
    }

    @Step("Select birthday: {day}")
    public RegistrationAlternativePage selectBirthday(String day) {
        webElements.selectValueInDropDown(daysInDropDown, day);
        return this;
    }

    @Step("Select birthday month: {month}")
    public RegistrationAlternativePage selectMonth(String month) {
        webElements.selectValueInDropDown(monthsInDropDown, month);
        return this;
    }

    @Step("Select birth year: {year}")
    public RegistrationAlternativePage selectYear(String year) {
        webElements.selectValueInDropDown(yearsInDropDown, year);
        return this;
    }

    @Step("Input first name: {firstName}")
    public RegistrationAlternativePage inputFirstName(String firstName) {
        webElements.inputText(fistNameField, firstName);
        return this;
    }

    @Step("Input last name: {lastName}")
    public RegistrationAlternativePage inputLastName(String lastName) {
        webElements.inputText(lastNameField, lastName);
        return this;
    }

    @Step("Input street: {street}")
    public RegistrationAlternativePage inputStreet(String street) {
        webElements.inputText(streetField, street);
        return this;
    }

    @Step("Input city: {city}")
    public RegistrationAlternativePage inputCity(String city) {
        webElements.inputText(cityField, city);
        return this;
    }

    @Step("Select state: {text}")
    public RegistrationAlternativePage selectState(String text) {
        webElements.selectTextInDropDownByText(stateSelect, text);
        return this;
    }

    @Step("Select country: {text}")
    public RegistrationAlternativePage selectCountry(String text) {
        webElements.selectTextInDropDownByText(countryField, text);
        return this;
    }

    @Step("Input post code: {postCode}")
    public RegistrationAlternativePage inputPostCode(String postCode) {
        webElements.inputText(postCodeField, postCode);
        return this;
    }

    @Step("Input mobile: {mobile}")
    public RegistrationAlternativePage inputMobilePhone(String phone) {
        webElements.inputText(phoneMobile, phone);
        return this;
    }

    @Step("Input alias: {alias}")
    public RegistrationAlternativePage inputAliasAddress(String alias) {
        webElements.inputText(aliasField, alias);
        return this;
    }

    @Step("Submit account")
    public RegistrationAlternativePage clickToButtonSubmitAccount() {
        webElements.clickOnElement(submitButtonAccount);
        return this;
    }

    public RegistrationAlternativePage registrationNewUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFN(account.getFirstCustomerName());
        inputCustomerLN(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPassword());
        selectBirthday(account.getDay());
        selectMonth(account.getMonth());
        selectYear(account.getYear());
        inputFirstName(account.getFistName());
        inputLastName(account.getLastName());
        inputStreet(account.getAddress1());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostCode(account.getPostCode());
        selectCountry(account.getCountry());
        inputMobilePhone(account.getPhoneNumber());
        inputAliasAddress(account.getAlias());
        return this;
    }
}