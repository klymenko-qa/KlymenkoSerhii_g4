package suits;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import ui.registrationTests.RegistrationTests;

public class ParallelTests {

    @Test
    public void runAllBrowserTests() {
        Class<?>[]  classes =
                {
                        RegistrationTests.class
                };
        // Parallel computer(true, true) will run all classes and methods
        // in parallel. (First arg for classes, second arg for methods)
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}