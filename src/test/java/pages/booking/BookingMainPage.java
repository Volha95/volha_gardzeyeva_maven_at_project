package pages.booking;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingMainPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(BookingMainPage.class.getName());

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
    private final By LOGIN_BUTTON = By.xpath("//a[@data-testid='header-sign-in-button']");
    private final By CAR_RENTAL = By.id("cars");

    public void findHotel(String city) {
        driver.findElement(CITY_AREA).sendKeys(city);
        LOGGER.trace("Input city, CITY_AREA locator: //input[@placeholder='Where are you going?']");
    }

    public void siteLoad() {
        driver.get(URL);
        LOGGER.trace("Opened the site 'https://www.booking.com/'");
    }

    public void inputFirstDate(int day, String month, int year) {
        driver.findElement(DATES_CONTAINER).click();
        LOGGER.trace("Find and click on dates, DATES_CONTAINER locator: //div[@data-testid='searchbox-dates-container']");
        String firstDate = "//span[@aria-label='%d %s %d']";
        driver.findElement(By.xpath(String.format(firstDate, day, month, year))).click();
        LOGGER.trace("Click on first date, locator: //span[@aria-label='%d %s %d']");
    }

    public void inputSecondDate(int day, String month, int year) {
        String secondDate = "//span[@aria-label='%d %s %d']";
        driver.findElement(By.xpath(String.format(secondDate, day, month, year))).click();
        LOGGER.trace("Click on second date, locator: //span[@aria-label='%d %s %d']");
    }

    public void adultsInput() {
        driver.findElement(PEOPLE_ROOMS_CONTAINER).click();
        LOGGER.trace("Click on room and people selection, PEOPLE_ROOMS_CONTAINER locator: //button[@data-testid='occupancy-config']");
        driver.findElement(ADULTS).click();
        LOGGER.trace("Click on element ADULTS, locator: //input[@id='group_adults']/following-sibling::div/button[2]");
    }

    public void roomsInput() {
        driver.findElement(ROOMS).click();
        LOGGER.trace("Click on element ROOMS, locator: //input[@id='no_rooms']/following-sibling::div/button[2]");
    }

    public void searchButtonClick() {
        driver.findElement(SEARCH_BUTTON).click();
        LOGGER.trace("Click on search-button, SEARCH_BUTTON locator: //span[text()='Search']");
    }

    public void dismissInfo() {
        driver.findElement(DISMISS_INFO).click();
        LOGGER.trace("Click on dismiss information, DISMISS_INFO locator: //button[contains(@aria-label, 'Dismiss sign-in info.') or contains(@aria-label, 'Скрыть меню входа в аккаунт.')]");
    }

    public WebElement getCurrency() {
        LOGGER.trace("Find currency element, CURRENCY locator: //button[@data-testid='header-currency-picker-trigger']");
        return driver.findElement(CURRENCY);
    }

    public WebElement getCurrencyTooltip() {
        LOGGER.trace("Find currency tooltip, CURRENCY_TOOLTIP locator: //div[text()='Select your currency']");
        return driver.findElement(CURRENCY_TOOLTIP);
    }

    public WebElement getLanguage() {
        LOGGER.trace("Find language element, LANGUAGE locator: //button[@data-testid='header-language-picker-trigger']");
        return driver.findElement(LANGUAGE);
    }

    public WebElement getLanguageTooltip() {
        LOGGER.trace("Find language tooltip, LANGUAGE_TOOlTIP locator: //div[text()='Select your language']");
        return driver.findElement(LANGUAGE_TOOlTIP);
    }

    public void registerClick() {
        driver.findElement(REGISTER_BUTTON).click();
        LOGGER.trace("Click on register button, REGISTER_BUTTON locator: //a[@data-testid='header-sign-up-button']");
    }
    public void loginClick() {
        driver.findElement(LOGIN_BUTTON).click();
        LOGGER.trace("Click on login button, LOGIN_BUTTON locator: //a[@data-testid='header-sign-in-button']");
    }
    public void goToCarRent() {
        driver.findElement(CAR_RENTAL).click();
        LOGGER.trace("Click on button car rent, CAR_RENTAL locator by id: cars ");
    }
}
