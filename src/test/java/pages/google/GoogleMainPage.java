package pages.google;

import classwork.day13.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMainPage {
    private final By SEARCH_AREA = By.xpath("//textarea[@role='combobox']");
    private final By HEADLINES = By.xpath("//h3");
    private final By HEADLINES_WITH_TUTORIAL = By.xpath("//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL')]");

    public WebElement getGoogleSearch() {
        return Driver.getWebDriver().findElement(SEARCH_AREA);
    }

    public List<WebElement> getHeadlines() {
        return Driver.getWebDriver().findElements(HEADLINES);
    }
    public List<WebElement> getTutorialHeadlines() {
        return Driver.getWebDriver().findElements(HEADLINES_WITH_TUTORIAL);
    }
}
