package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarRentalPage {
    WebDriver driver = Driver.getWebDriver();
    private final By CITY_CAR_SEARCH = By.xpath("//div[@data-testid='sbc-fl-text-input__container']");
    public void inputCity() {
        driver.findElement(CITY_CAR_SEARCH).sendKeys("London");
    }
}
