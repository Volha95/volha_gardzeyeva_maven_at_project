package pages.booking;

import classwork.day11.WebDriverWeather;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingMainPage {
    private static final Logger LOGGER = Logger.getLogger(WebDriverWeather.class.getName());

    private final String URL = "https://www.booking.com/";

    private final By DISMISS_INFO = By.xpath("//button[contains(@aria-label, 'Dismiss sign-in info.') or contains(@aria-label, 'Скрыть меню входа в аккаунт.')]");

    private final By CITY_AREA = By.xpath("//input[@placeholder='Where are you going?']");
    private final By DATES_CONTAINER = By.xpath("//div[@data-testid='searchbox-dates-container']");
    private final By SEARCH_BUTTON = By.xpath("//span[text()='Search']");
    private final By PEOPLE_ROOMS_CONTAINER = By.xpath("//button[@data-testid='occupancy-config']");
    private final By ADULTS = By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]");
    private final By ROOMS = By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]");
    private final By CURRENCY = By.xpath("//button[@data-testid='header-currency-picker-trigger']");
    private final By CURRENCY_TOOLTIP = By.xpath("//div[text()='Select your currency']");
    private final By LANGUAGE = By.xpath("//button[@data-testid='header-language-picker-trigger']");
    private final By LANGUAGE_TOOlTIP = By.xpath("//div[text()='Select your language']");
    private final By REGISTER_BUTTON = By.xpath("//a[@data-testid='header-sign-up-button']");

    public void findHotel(String city) {
        Driver.getWebDriver().findElement(CITY_AREA).sendKeys(city);
    }

    public void siteLoad() {
        Driver.getWebDriver().get(URL);

    }

    public void inputFirstDate(int day, String month, int year) {
        Driver.getWebDriver().findElement(DATES_CONTAINER).click();
        String firstDate = "//span[@aria-label='%d %s %d']";
        Driver.getWebDriver().findElement(By.xpath(String.format(firstDate, day, month, year))).click();
    }
    public void inputSecondDate(int day, String month, int year) {
        String secondDate = "//span[@aria-label='%d %s %d']";
        Driver.getWebDriver().findElement(By.xpath(String.format(secondDate, day, month, year))).click();
    }

    public void adultsInput() {
        Driver.getWebDriver().findElement(PEOPLE_ROOMS_CONTAINER).click();
        Driver.getWebDriver().findElement(ADULTS).click();
    }

    public void roomsInput() {
        Driver.getWebDriver().findElement(ROOMS).click();
    }

    public void searchButtonClick() {
        Driver.getWebDriver().findElement(SEARCH_BUTTON).click();
    }

    public void dismissInfo() {
        Driver.getWebDriver().findElement(DISMISS_INFO).click();
    }

    public WebElement getCurrency() {
        return Driver.getWebDriver().findElement(CURRENCY);
    }

    public WebElement getCurrencyTooltip() {
        return Driver.getWebDriver().findElement(CURRENCY_TOOLTIP);
    }

    public WebElement getLanguage() {
        return Driver.getWebDriver().findElement(LANGUAGE);
    }

    public WebElement getLanguageTooltip() {
        return Driver.getWebDriver().findElement(LANGUAGE_TOOlTIP);
    }

    public void registerClick() {
        Driver.getWebDriver().findElement(REGISTER_BUTTON).click();
    }

}
