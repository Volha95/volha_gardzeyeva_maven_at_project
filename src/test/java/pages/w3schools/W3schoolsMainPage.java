package pages.w3schools;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class W3schoolsMainPage {
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
