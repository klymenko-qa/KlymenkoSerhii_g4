package ui.registrationTests;

import baseTest.BaseTests;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationTests extends BaseTests {

    @Test
    public void registrationTest() {
        mainPage.openUrl("http://automationpractice.com/");
        mainPage.clickToSignInPage();
        registrationPage.inputEmailCreate("tesdt23de33@gmail.com");
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN("Dima");
        registrationPage.inputCustomerLN("Hulak");
        registrationPage.inputEmail("tesdt23de33@gmail.com");
        registrationPage.inputPassword("qwertyy12312");
        registrationPage.inputFirstName("Dima");
        registrationPage.inputLastName("Hulak");
        registrationPage.inputStreet("street New York, 12");
        registrationPage.inputCity("New York");
        registrationPage.selectState(32);
        registrationPage.inputPostCode("12345");
        registrationPage.inputMobilePhone("1234567890");
        registrationPage.inputAliasAddress("tesdt23de33@gmail.com");
        registrationPage.clickToButtonSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());
    }
}