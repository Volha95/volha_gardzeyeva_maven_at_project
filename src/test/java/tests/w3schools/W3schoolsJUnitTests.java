package tests.w3schools;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.google.GoogleMainPage;
import pages.w3schools.W3schoolsMainPage;


public class W3schoolsJUnitTests {
    private static final Logger LOGGER = Logger.getLogger(W3schoolsJUnitTests.class.getName());
    Actions make = new Actions(Driver.getWebDriver());
    W3schoolsMainPage w3schoolsMainPage = new W3schoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    @Before
    public void loadingPage() {
        LOGGER.info("Test started");
        w3schoolsMainPage.siteLoad();
    }
    @After
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
        Assert.assertEquals("the result doesn't contain the word 'tutorial'", googleMainPage.getHeadlines().size(), googleMainPage.getTutorialHeadlines().size());
    }
}
