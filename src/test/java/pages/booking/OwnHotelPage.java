package pages.booking;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OwnHotelPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(OwnHotelPage.class.getName());
    private final By SCORE_ELEMENT = By.xpath("//div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Scored')]");

    public WebElement findScoreElement() {
        LOGGER.trace("Find score element, SCORE_ELEMENT locator: //div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Scored')]");
        return driver.findElement(SCORE_ELEMENT);
    }
}
