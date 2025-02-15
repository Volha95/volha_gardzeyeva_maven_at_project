package pages.w3schools;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3schoolsMainPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(W3schoolsMainPage.class.getName());
    private final By TUTORIAL_TEXT = By.xpath("//span[text()='Tutorial']");

    public void siteLoad() {
        driver.get("https://www.w3schools.com/java/");
        LOGGER.trace("Go to w3schools site 'https://www.w3schools.com/java/'");
    }

    public WebElement getTutorialText() {
        LOGGER.trace("Find word 'Tutorial', TUTORIAL_TEXT locator: //span[text()='Tutorial']");
        return driver.findElement(TUTORIAL_TEXT);
    }

    public void navigateGoogle() {
        driver.navigate().to("https://www.google.com/");
        LOGGER.trace("Go to Google 'https://www.google.com/'");
    }
}
