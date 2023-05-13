package runners.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.BookingJUnitTests;
import tests.demoQA.DemoQAJUnitTests;
import tests.w3schools.W3schoolsJUnitTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookingJUnitTests.class,
        DemoQAJUnitTests.class,
        W3schoolsJUnitTests.class
})

public class BookingJUnitRunner {
}
