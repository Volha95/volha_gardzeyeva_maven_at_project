package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.BookingJUnitTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookingJUnitTests.class,

})

public class BookingJUnitRunner {

}
