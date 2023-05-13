package runners.junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.demoQA.DemoQAJUnitTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DemoQAJUnitTests.class
})
public class DemoQAJUnitRunner {
}
