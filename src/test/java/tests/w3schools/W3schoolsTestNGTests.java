package tests.w3schools;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.google.GoogleMainPage;
import pages.w3schools.W3schoolsMainPage;

public class W3schoolsTestNGTests {
    private static final Logger LOGGER = Logger.getLogger(W3schoolsTestNGTests.class.getName());
    Actions make = new Actions(Driver.getWebDriver());
    W3schoolsMainPage w3schoolsMainPage = new W3schoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
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
        make.doubleClick(w3schoolsMainPage.getTutorialText())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        w3schoolsMainPage.navigateGoogle();
        make.click(googleMainPage.getGoogleSearch())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        Assert.assertEquals(googleMainPage.getHeadlines().size(), googleMainPage.getTutorialHeadlines().size(), "the result doesn't contain the word 'tutorial'");
        LOGGER.debug("Test passed");
    }
}
