package runners.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.w3schools.W3schoolsJUnitTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        W3schoolsJUnitTests.class
})

public class W3schoolsJUnitRunner {
}
