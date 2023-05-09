package utils;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.google.GoogleMainPage;
import pages.w3schools.W3schoolsMainPage;

public class W3schoolsActions {
    WebDriver driver = Driver.getWebDriver();
    Actions make = new Actions(driver);
    W3schoolsMainPage w3schoolsMainPage = new W3schoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    public void copyTutorial() {
        make.doubleClick(w3schoolsMainPage.getTutorialText())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }
    public void pasteToGoogleSearch() {
        make.click(googleMainPage.getGoogleSearch())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}
