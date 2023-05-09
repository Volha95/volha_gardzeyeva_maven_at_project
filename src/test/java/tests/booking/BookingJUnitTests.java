package tests.booking;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.booking.BookingMainPage;
import pages.booking.FoundHotelsPage;
import pages.booking.OwnHotelPage;
import pages.booking.RegistrationPage;

public class BookingJUnitTests {
    private static final Logger LOGGER = Logger.getLogger(BookingJUnitTests.class.getName());
    BookingMainPage bookingMainPage = new BookingMainPage();
    FoundHotelsPage foundHotelsPage = new FoundHotelsPage();
    RegistrationPage registrationPage = new RegistrationPage();
    OwnHotelPage ownHotelPage = new OwnHotelPage();
    Actions actions = new Actions(Driver.getWebDriver());

    @Before
    public void loadingPage() {
        LOGGER.info("Test started");
        bookingMainPage.siteLoad();
        bookingMainPage.dismissInfo();
    }

    @After
    public void closingPage() {
        Driver.destroy();
        LOGGER.info("Test finished");
    }

    @Test
    public void maxPricePerNight() {
        bookingMainPage.findHotel("Париж");
        bookingMainPage.inputFirstDate(10, "May", 2023);
        bookingMainPage.inputSecondDate(18, "May", 2023);
        bookingMainPage.adultsInput();
        bookingMainPage.adultsInput();
        bookingMainPage.roomsInput();
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        foundHotelsPage.sortDropdownClick();
        foundHotelsPage.sortFromCheapest();
        String priceHotel = foundHotelsPage.getFirstHotelPrice().getText();
        String priceHotelNumberOnly = priceHotel.replaceAll("[^0-9]", "");
        String priceNight = foundHotelsPage.getPricePerNight().getText();
        String priceNightNumberOnly = priceNight.replaceAll("[^0-9]", "");
        double hotelPrice = Double.parseDouble(priceHotelNumberOnly);
        double nightPrice = Double.parseDouble(priceNightNumberOnly);
        Assert.assertTrue("the cost of a night in a hotel is less than the minimum", hotelPrice / 7 >= nightPrice);
        LOGGER.debug("Test passed");
    }

    @Test
    public void makeRedTitle() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.inputFirstDate(10, "May", 2023);
        bookingMainPage.inputSecondDate(18, "May", 2023);
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", foundHotelsPage.getTenthHotel());
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", foundHotelsPage.getTenthHotel());
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.color = 'red'", foundHotelsPage.getTenthHotelTitle());
        Assert.assertEquals("hotel name isn't red", "color: red;", foundHotelsPage.findRedElement());
        LOGGER.debug("Test passed");
    }

    @Test
    public void checkingTooltipCurrency() {
        actions.moveToElement(bookingMainPage.getCurrency());
        actions.perform();
        Assert.assertTrue("tooltip isn't displayed", bookingMainPage.getCurrencyTooltip().isDisplayed());
        LOGGER.debug("Test passed");
    }

    @Test
    public void checkingTooltipLanguage() {
        actions.moveToElement(bookingMainPage.getLanguage());
        actions.perform();
        Assert.assertTrue("tooltip isn't displayed", bookingMainPage.getLanguageTooltip().isDisplayed());
        LOGGER.debug("Test passed");
    }

    @Test
    public void hotelsPresence() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.inputFirstDate(10, "May", 2023);
        bookingMainPage.inputSecondDate(18, "May", 2023);
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        Assert.assertTrue("There are no hotels for the entered dates", foundHotelsPage.getPropertyCard().size() > 0);
        LOGGER.debug("Test passed");
    }

    @Test
    public void hotelRatingMax() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.inputFirstDate(10, "May", 2023);
        bookingMainPage.inputSecondDate(18, "May", 2023);
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        foundHotelsPage.filterMaxRating();
        foundHotelsPage.spinnerWait();
        foundHotelsPage.openFirstHotelPage();
        double score = Double.parseDouble(ownHotelPage.findScoreElement().getText());
        Assert.assertTrue("hotel rating less than 9", score >= 9.0);
        LOGGER.debug("Test passed");
    }

    @Test
    public void registerNewUser() {
        bookingMainPage.registerClick();
        registrationPage.registration();

    }

}
