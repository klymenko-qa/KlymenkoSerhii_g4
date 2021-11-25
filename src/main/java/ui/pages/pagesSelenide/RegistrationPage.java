package ui.pages.pagesSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public final ElementsCollection genders = $$x("//input[@name='id_gender']");

    public final SelenideElement
            genderMr = $x("//div[@class='radio-inline'][1]"),
            genderMrs = $x("//div[@class='radio-inline'][2]"),
            customerFirstNameField = $(By.id("customer_firstname")),
            customerLastNameField = $(By.id("customer_lastname")),
            emailField = $(By.id("email")),
            passwordField = $(By.id("passwd")),
            daysInDropDown = $(By.id("days")),
            monthsInDropDown = $(By.id("months")),
            yearsInDropDown = $(By.id("years")),
            titleYourAddress = $x("//h3[contains(text(),'Your address')]"),
            fistNameField = $x("//input[@id='firstname']"),
            lastNameField =  $x("//input[@id='lastname']"),
            streetField = $x("//div[@class='account_creation']//p[4]/input[@type='text']"),
            cityField = $(By.id("city")),
            stateSelect = $x("//select[@id='id_state']"),
            postCodeField = $(By.id("postcode")),
            countryField = $(By.id("id_country")),
            phoneMobile = $(By.id("phone_mobile")),
            aliasField = $(By.id("alias")),
            submitButtonAccount = $(By.id("submitAccount"));

    @Step("Select gender: {gender}")
    public RegistrationPage selectGender(String gender) {
        if (gender.equals("1")) {
            genders.get(0).selectRadio(gender);
        } else {
            genders.get(1).selectRadio(gender);
        }
        return this;
    }

    @Step("Input customer first name; {firstName}")
    public RegistrationPage inputCustomerFN(String firstName) {
        customerFirstNameField.setValue(firstName);
        return this;
    }

    @Step("Input customer last name; {lastName}")
    public RegistrationPage inputCustomerLN(String lastName) {
        customerLastNameField.setValue(lastName);
        return this;
    }

    @Step("Input email: {email}")
    public RegistrationPage inputEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Input password: {password}")
    public RegistrationPage inputPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Select birthday: {day}")
    public RegistrationPage selectBirthday(String day) {
        daysInDropDown.selectOptionByValue(day);
        return this;
    }

    @Step("Select birthday month: {month}")
    public RegistrationPage selectMonth(String month) {
        monthsInDropDown.selectOptionByValue(month);
        return this;
    }

    @Step("Select birth year: {year}")
    public RegistrationPage selectYear(String year) {
        yearsInDropDown.selectOptionByValue(year);
        return this;
    }

    @Step("Input first name: {firstName}")
    public RegistrationPage inputFirstName(String firstName) {
        fistNameField.setValue(firstName);
        return this;
    }

    @Step("Input last name: {lastName}")
    public RegistrationPage inputLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    @Step("Input street: {street}")
    public RegistrationPage inputStreet(String street) {
        streetField.setValue(street);
        return this;
    }

    @Step("Input city: {city}")
    public RegistrationPage inputCity(String city) {
        cityField.setValue(city);
        return this;
    }

    @Step("Select state: {text}")
    public RegistrationPage selectState(String text) {
        stateSelect.selectOptionContainingText(text);
        return this;
    }

    @Step("Select country: {text}")
    public RegistrationPage selectCountry(String text) {
        countryField.selectOptionContainingText(text);
        return this;
    }

    @Step("Input post code: {postCode}")
    public RegistrationPage inputPostCode(String postCode) {
        postCodeField.setValue(postCode);
        return this;
    }

    @Step("Input mobile: {mobile}")
    public RegistrationPage inputMobilePhone(String phone) {
        phoneMobile.setValue(phone);
        return this;
    }

    @Step("Input alias: {alias}")
    public RegistrationPage inputAliasAddress(String alias) {
        aliasField.setValue(alias);
        return this;
    }

    @Step("Submit account")
    public RegistrationPage clickToButtonSubmitAccount() {
        submitButtonAccount.click();
        return this;
    }

    public RegistrationPage registrationNewUser(Account account) {
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