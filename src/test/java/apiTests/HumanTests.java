package apiTests;

import api.assertions.AssertableResponse;
import api.model.Human;
import api.services.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static api.conditions.Conditions.body;
import static api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.*;

public class HumanTests extends BaseTest {

    @Test
    void testGetUserName() {
        peopleApiServices
                .getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(body("name", is("Luke Skywalker")));
        Utils.resetSession();
    }

    @Test
    void testGetUser() {
        AssertableResponse r = peopleApiServices.getPeople();
        Assert.assertEquals(200, r.response.extract().statusCode());
        Assert.assertEquals("application/json", r.response.extract().contentType());
    }

    @Test
    void test() {
        List<Human> humans = peopleApiServices.getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(body("name", is(notNullValue())))
                .response.extract().body().jsonPath().get();
        Assert.assertTrue(humans.size() > 0);
        Assert.assertEquals("height", humans.get(0).height);
    }

    Human human = new Human()
            .setName("Luke Skywalker")
            .setHeight("172");

    @Test
    void test2() {
        Human human = peopleApiServices.getPeople()
                .shouldHave(statusCode(200))
                .response.extract().body().as(Human.class);
        Assert.assertEquals("name", human.name);
        Assert.assertEquals("height", human.height);
    }
}