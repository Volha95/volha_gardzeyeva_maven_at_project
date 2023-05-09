package pages.w3schools;

import classwork.day11.WebDriverWeather;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W3schoolsMainPage {
    private static final Logger LOGGER = Logger.getLogger(W3schoolsMainPage.class.getName());
    private final By TUTORIAL_TEXT = By.xpath("//span[text()='Tutorial']");

    public void siteLoad() {
        Driver.getWebDriver().get("https://www.w3schools.com/java/");
    }

    public WebElement getTutorialText() {
        return Driver.getWebDriver().findElement(TUTORIAL_TEXT);
    }

    public void navigateGoogle() {
        Driver.getWebDriver().navigate().to("https://www.google.com/");
    }
}
