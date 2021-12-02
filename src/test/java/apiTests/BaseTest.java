package apiTests;

import api.extentions.TestLoggingListener;
import api.services.PeopleApiServices;
import api.services.Utils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestLoggingListener.class)
public class BaseTest {

    public static PeopleApiServices peopleApiServices;
    public static Utils utils;

    @BeforeMethod
    @Step("Set up services")
    void setUpServices() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        peopleApiServices = new PeopleApiServices("/");
        utils = new Utils();
    }
}