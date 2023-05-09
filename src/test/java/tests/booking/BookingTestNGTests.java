package tests.booking;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.booking.BookingMainPage;
import pages.booking.FoundHotelsPage;
import pages.booking.OwnHotelPage;

public class BookingTestNGTests {
    BookingMainPage bookingMainPage = new BookingMainPage();
    FoundHotelsPage foundHotelsPage = new FoundHotelsPage();
    OwnHotelPage ownHotelPage = new OwnHotelPage();
    Actions actions = new Actions(Driver.getWebDriver());

    @BeforeMethod
    public void loadingPage() {
        bookingMainPage.siteLoad();
        bookingMainPage.dismissInfo();
    }

    @AfterClass
    public void driverClose() {
        Driver.destroy();
    }

    @AfterMethod
    public void closingPage() {
        Driver.close();
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
        Assert.assertTrue(hotelPrice / 7 >= nightPrice, "the cost of a night in a hotel is less than the minimum");
    }

    @Test
    public void makeRedTitle() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", foundHotelsPage.getTenthHotel());
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", foundHotelsPage.getTenthHotel());
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.color = 'red'", foundHotelsPage.getTenthHotelTitle());
        Assert.assertEquals("hotel name isn't red", "color: red;", foundHotelsPage.findRedElement());
    }

    @Test
    public void checkingTooltipCurrency() {
        actions.moveToElement(bookingMainPage.getCurrency());
        actions.perform();
        Assert.assertTrue(bookingMainPage.getCurrencyTooltip().isDisplayed(), "tooltip isn't displayed");
    }

    @Test
    public void checkingTooltipLanguage() {
        actions.moveToElement(bookingMainPage.getLanguage());
        actions.perform();
        Assert.assertTrue(bookingMainPage.getLanguageTooltip().isDisplayed(), "tooltip isn't displayed");
    }

    @Test
    public void hotelsPresence() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        Assert.assertTrue(foundHotelsPage.getPropertyCard().size() > 0, "There are no hotels for the entered dates");
    }

    @Test
    public void hotelRatingMax() {
        bookingMainPage.findHotel("Berlin");
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        foundHotelsPage.filterMaxRating();
        foundHotelsPage.spinnerWait();
        foundHotelsPage.openFirstHotelPage();
        double score = Double.parseDouble(ownHotelPage.findScoreElement().getText());
        Assert.assertTrue(score >= 9.0, "hotel rating less than 9");
    }

    @Test
    public void registerNewUser() {
        bookingMainPage.registerClick();

    }
}
