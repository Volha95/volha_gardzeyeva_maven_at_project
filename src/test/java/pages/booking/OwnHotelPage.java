package pages.booking;

import classwork.day13.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OwnHotelPage {

    private final By SCORE_ELEMENT = By.xpath("//div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Scored')]");

    public WebElement findScoreElement() {
        return Driver.getWebDriver().findElement(SCORE_ELEMENT);
    }
}
