package seleniumTests;

import baseTest.BaseTests;
import org.junit.Assert;
import org.junit.Test;

public class SeleniumTestHW5 extends BaseTests {

    private final String RANDOM_EMAIL = faker.internet().emailAddress();

    public SeleniumTestHW5(String browser) {
        super(browser);
    }

    @Test
    public void verifyErrorMessageTest() {
        mainPage.openUrl("http://automationpractice.com/");
        mainPage.clickToSignInPage();
        registrationPage.inputEmailCreate(RANDOM_EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN("User");
        registrationPage.inputCustomerLN("Automation");
        registrationPage.inputEmail(RANDOM_EMAIL);
        registrationPage.inputPassword("qwerty123");
        registrationPage.inputFirstName("User");
        registrationPage.inputLastName("Automation");
        registrationPage.inputStreet("street New York, 12");
        registrationPage.inputCity("New York");
        registrationPage.inputPostCode("12345");
        registrationPage.inputMobilePhone("1234567890");
        registrationPage.inputAliasAddress(RANDOM_EMAIL);
        registrationPage.clickToButtonSubmitAccount();
        Assert.assertEquals("There is 1 error\n" +
                        "This country requires you to choose a State.",
                registrationPage.checkErrorMessage());
    }
}
