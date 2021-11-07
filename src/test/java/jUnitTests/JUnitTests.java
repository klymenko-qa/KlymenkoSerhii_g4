package jUnitTests;

import org.junit.*;
import org.junit.rules.Timeout;

import java.util.NoSuchElementException;

public class JUnitTests {

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Before
    public void before() {
        System.out.println("Before test");
    }

    @After
    public void after() {
        System.out.println("After class");
    }

    @Test(timeout = 1000)
//    @Test(expected = NoSuchElementException.class)
//    @Ignore
    public void test() {
        System.out.println("Test");
        Assert.assertEquals("Test", "Test");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
        Assert.fail("Test");
    }
}
