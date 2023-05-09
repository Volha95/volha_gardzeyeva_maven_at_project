package classwork.day14;

import classwork.day11.WebDriverWeather;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class DemoSteps {
    private static final Logger LOGGER = Logger.getLogger(WebDriverWeather.class.getName());
    @Given("I open demoG7 site")
    public void iOpenDemoGSite() {
        LOGGER.info("I opened the site");
    }
    @When("I fill {string} in the form")
    public void iFillInTheForm(String text) {
        LOGGER.info(String.format("I printed '%s' the string", text));
    }

    @Then("I need to see something")
    public void iNeedToSeeSomething() {
        Assert.assertTrue(true);
        LOGGER.info("I finished");
    }
}
