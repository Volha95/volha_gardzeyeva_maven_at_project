package pages.google;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMainPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(GoogleMainPage.class.getName());
    private final By SEARCH_AREA = By.xpath("//textarea[@role='combobox']");
    private final By HEADLINES = By.xpath("//h3");
    private final By HEADLINES_WITH_TUTORIAL = By.xpath("//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL')]");

    public WebElement getGoogleSearch() {
        LOGGER.trace("Find google search element, SEARCH_AREA locator: //textarea[@role='combobox']");
        return driver.findElement(SEARCH_AREA);
    }

    public List<WebElement> getHeadlines() {
        LOGGER.trace("Find headlines elements, HEADLINES locator: //h3");
        return driver.findElements(HEADLINES);
    }
    public List<WebElement> getTutorialHeadlines() {
        LOGGER.trace("Find headlines elements with 'tutorial' word, HEADLINES_WITH_TUTORIAL locator: //h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL')]");
        return driver.findElements(HEADLINES_WITH_TUTORIAL);
    }
}
