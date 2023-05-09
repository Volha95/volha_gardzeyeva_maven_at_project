package pages.booking;

import classwork.day11.WebDriverWeather;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FoundHotelsPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(FoundHotelsPage.class.getName());
    private final By SPINNER = By.xpath("//div[@data-testid='overlay-spinner']");
    private final By SORT_DROPDOWN = By.xpath("//button[@data-testid='sorters-dropdown-trigger']");
    private final By MIN_PRICE_SORT = By.xpath("//button[@data-id='price']");
    private final By FIRST_HOTEL_PRICE = By.xpath("//div[@data-testid='property-card'][1]//span[@data-testid='price-and-discounted-price']");
    private final By PRICE_PER_NIGHT_FILTER = By.xpath("//div[@data-testid='filters-sidebar']/div[2]//div[@data-filters-item='pri:pri=5']");
    private final By TENTH_HOTEL = By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]");
    private final By TENTH_HOTEL_TITLE = By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]//div[@data-testid='title']");
    private final By TENTH_HOTEL_RED_TITLE = By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]//div[@style='color: red;']");
    private final By PROPERTY_CARD = By.xpath("//div[@data-testid='property-card']");
    private final By MAX_RATING_FILTER = By.xpath("//div[@role='complementary']//div[@data-filters-item='review_score:review_score=90']");
    private final By FIRST_HOTEL_TITLE = By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='title']");


    public void spinnerWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.invisibilityOfElementLocated(SPINNER));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void sortDropdownClick() {
        driver.findElement(SORT_DROPDOWN).click();
    }

    public void sortFromCheapest() {
        driver.findElement(MIN_PRICE_SORT).click();
    }

    public WebElement getFirstHotelPrice() {
        return driver.findElement(FIRST_HOTEL_PRICE);
    }

    public WebElement getPricePerNight() {
        return driver.findElement(PRICE_PER_NIGHT_FILTER);
    }

    public WebElement getTenthHotel() {
        return driver.findElement(TENTH_HOTEL);
    }

    public WebElement getTenthHotelTitle() {
        return driver.findElement(TENTH_HOTEL_TITLE);
    }

    public String findRedElement() {
        WebElement redElement = driver.findElement(TENTH_HOTEL_RED_TITLE);
        return redElement.getAttribute("style");
    }

    public List<WebElement> getPropertyCard() {
        return driver.findElements(PROPERTY_CARD);
    }

    public void filterMaxRating() {
        driver.findElement(MAX_RATING_FILTER).click();
    }

    public void openFirstHotelPage() {
        driver.findElement(FIRST_HOTEL_TITLE).click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }
}
