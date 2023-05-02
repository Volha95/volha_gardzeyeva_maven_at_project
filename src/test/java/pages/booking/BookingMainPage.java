package pages.booking;

import classwork.day13.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingMainPage {

    WebDriver driver = Driver.getWebDriver();
    private final String URL = "https://www.booking.com/";

    private final By DISMISS_INFO = By.xpath("//button[contains(@aria-label, 'Dismiss sign-in info.') or contains(@aria-label, 'Скрыть меню входа в аккаунт.')]");

    private final By CITY_AREA = By.xpath("//input[@placeholder='Where are you going?']");
    private final By DATES_CONTAINER = By.xpath("//div[@data-testid='searchbox-dates-container']");
    private final By FIRST_DATE = By.xpath("//span[@aria-label='3 May 2023']");
    private final By SECOND_DATE = By.xpath("//span[@aria-label='10 May 2023']");
    private final By SEARCH_BUTTON = By.xpath("//span[text()='Search']");
    private final By PEOPLE_ROOMS_CONTAINER = By.xpath("//button[@data-testid='occupancy-config']");
    private final By ADULTS = By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]");
    private final By ROOMS = By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]");
    private final By CURRENCY = By.xpath("//button[@data-testid='header-currency-picker-trigger']");
    private final By CURRENCY_TOOLTIP = By.xpath("//div[text()='Select your currency']");
    private final By LANGUAGE = By.xpath("//button[@data-testid='header-language-picker-trigger']");
    private final By LANGUAGE_TOOlTIP = By.xpath("//div[text()='Select your language']");

    public void findHotel(String city) {
        driver.findElement(CITY_AREA).sendKeys(city);
        driver.findElement(DATES_CONTAINER).click();
        driver.findElement(FIRST_DATE).click();
        driver.findElement(SECOND_DATE).click();
    }
    public void siteLoad() {
        driver.get(URL);

    }

    public void adultsInput() {
        driver.findElement(PEOPLE_ROOMS_CONTAINER).click();
        driver.findElement(ADULTS).click();
    }

    public void roomsInput() {
        driver.findElement(ROOMS).click();
    }

    public void searchButtonClick() {
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void dismissInfo() {
        driver.findElement(DISMISS_INFO).click();
    }
    public WebElement getCurrency() {
        return driver.findElement(CURRENCY);
    }
    public WebElement getCurrencyTooltip() {
        return driver.findElement(CURRENCY_TOOLTIP);
    }
    public WebElement getLanguage() {
        return driver.findElement(LANGUAGE);
    }
    public WebElement getLanguageTooltip() {
        return driver.findElement(LANGUAGE_TOOlTIP);
    }

}
