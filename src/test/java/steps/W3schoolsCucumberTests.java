package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import io.cucumber.java.After;
import org.junit.Assert;
import io.cucumber.java.Before;
import pages.google.GoogleMainPage;
import pages.w3schools.W3schoolsMainPage;
import utils.W3schoolsActions;

public class W3schoolsCucumberTests {
    private static final Logger LOGGER = Logger.getLogger(W3schoolsCucumberTests.class.getName());
    W3schoolsMainPage w3schoolsMainPage = new W3schoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    W3schoolsActions w3schoolsActions = new W3schoolsActions();
    @Before
    public void getDriver() {
        LOGGER.info("Test started");
        Driver.getWebDriver();
    }

    @After
    public void closeDriver() {
        Driver.destroy();
        LOGGER.info("Test finished");
    }
    @Given("I open W3schools site")
    public void openSite() {
        w3schoolsMainPage.siteLoad();
        LOGGER.debug("Step completed");
    }

    @When("I copy the word")
    public void iCopyTheWord() {
        w3schoolsActions.copyTutorial();
        LOGGER.debug("Step completed");
    }

    @And("Go to Google")
    public void goToGoogle() {
        w3schoolsMainPage.navigateGoogle();
        LOGGER.debug("Step completed");
    }

    @And("Paste the word to the Google search")
    public void pasteTheWordToTheGoogleSearch() {
        w3schoolsActions.pasteToGoogleSearch();
        LOGGER.debug("Step completed");
    }

    @Then("Count number of words")
    public void countNumberOfWords() {
        Assert.assertEquals("the result doesn't contain the word 'tutorial'", googleMainPage.getHeadlines().size(), googleMainPage.getTutorialHeadlines().size());
        LOGGER.debug("Step completed");
    }
}
