package pages.booking;

import classwork.day11.WebDriverWeather;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OwnHotelPage {
    private static final Logger LOGGER = Logger.getLogger(OwnHotelPage.class.getName());
    private final By SCORE_ELEMENT = By.xpath("//div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Scored')]");

    public WebElement findScoreElement() {
        return Driver.getWebDriver().findElement(SCORE_ELEMENT);
    }
}
