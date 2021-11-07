package jUnitTests;

import com.google.common.math.LongMath;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Tests {

    @RegisterExtension
    public String text = "Text";

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After class");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before test");
    }

    @AfterEach
    public void after() {
        System.out.println("After test");
    }

    @Test
    public void test() {
        System.out.println("Test");
        Assertions.assertAll(
                () -> assertTrue(LongMath.isPrime(2)),
                () -> assertFalse(LongMath.isPrime(4))
        );
    }

    @Test
    public void test2() {
        System.out.println("test2");
        Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(10));
    }
}