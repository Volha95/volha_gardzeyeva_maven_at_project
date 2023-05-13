package tests.w3schools;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;
import pages.google.GoogleMainPage;
import pages.w3schools.W3schoolsMainPage;
import utils.W3schoolsActions;

public class W3schoolsTestNGTests {
    private static final Logger LOGGER = Logger.getLogger(W3schoolsTestNGTests.class.getName());
    Actions make = new Actions(Driver.getWebDriver());
    W3schoolsMainPage w3schoolsMainPage = new W3schoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    W3schoolsActions w3schoolsActions = new W3schoolsActions();

    @BeforeMethod
    public void loadingPage() {
        LOGGER.info("Test started");
        w3schoolsMainPage.siteLoad();
    }

    @AfterMethod
    public void closingPage() {
        Driver.destroy();
        LOGGER.info("Test finished");
    }

    @Test
    public void tutorialTest() {
        w3schoolsActions.copyTutorial();
        w3schoolsMainPage.navigateGoogle();
        w3schoolsActions.pasteToGoogleSearch();
        Assert.assertEquals(googleMainPage.getTutorialHeadlines().size(), googleMainPage.getHeadlines().size(), "the result doesn't contain the word 'tutorial'");
        LOGGER.debug("Test passed");
    }
}
