package ui.registrationTests;

import baseTest.BaseTests;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationTests extends BaseTests {

    public RegistrationTests(String browser) {
        super(browser);
    }

    private final String RANDOM_EMAIL = faker.internet().emailAddress();

    //@Test
    public void registrationTest() {
        mainPage.openUrl("http://automationpractice.com/");
        mainPage.clickToSignInPage();
        registrationPage.inputEmailCreate(RANDOM_EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFN("Dima");
        registrationPage.inputCustomerLN("Hulak");
        registrationPage.inputEmail(RANDOM_EMAIL);
        registrationPage.inputPassword("qwertyy12312");
        registrationPage.inputFirstName("Dima");
        registrationPage.inputLastName("Hulak");
        registrationPage.inputStreet("street New York, 12");
        registrationPage.inputCity("New York");
        registrationPage.selectState("New York");
        registrationPage.inputPostCode("12345");
        registrationPage.inputMobilePhone("1234567890");
        registrationPage.inputAliasAddress(RANDOM_EMAIL);
        registrationPage.clickToButtonSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());
        myAccountPage.checkTitle(
                "Title",
                myAccountPage.checkTitleTextOnPage("My account - My Store"),
                true);
    }

    @Test
    public void registrationTest_2() {
        mainPage.openUrl("http://automationpractice.com/");
        mainPage.clickToSignInPage();
        registrationAlternativePage
                .inputEmailCreate(RANDOM_EMAIL + "117_")
                .submitButtonCreate()
                .inputCustomerFN("Dima")
                .inputCustomerLN("Hulak")
                .inputEmail(RANDOM_EMAIL)
                .inputPassword("qwertyy12312")
                .inputFirstName("Dima")
                .inputLastName("Hulak")
                .inputStreet("street New York, 12")
                .inputCity("New York")
                .selectState("New York")
                .inputPostCode("12345")
                .inputMobilePhone("1234567890")
                .inputAliasAddress(RANDOM_EMAIL)
                .clickToButtonSubmitAccount();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());
    }
}