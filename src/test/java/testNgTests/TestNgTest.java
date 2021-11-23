package testNgTests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @BeforeMethod
    public void before() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void after() {
        System.out.println("After method");
    }

    @BeforeSuite
    @AfterSuite
    @BeforeTest
    @AfterTest
    @BeforeGroups
    @AfterGroups

    @Test(groups = "test1")
//    @Test(enabled = false)
//    @Test(expectedExceptions = ArithmeticException.class)
    public void test1() {
        Assert.assertEquals("res", "res");
    }
}