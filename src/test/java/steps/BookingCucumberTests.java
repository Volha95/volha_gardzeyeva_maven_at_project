package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pages.booking.BookingMainPage;
import pages.booking.FoundHotelsPage;

public class BookingCucumberTests {
    private static final Logger LOGGER = Logger.getLogger(BookingCucumberTests.class.getName());
    BookingMainPage bookingMainPage = new BookingMainPage();
    FoundHotelsPage foundHotelsPage = new FoundHotelsPage();
    @Before
    public void getDriver() {
        LOGGER.info("Test started");
        Driver.getWebDriver();
    }
    @After
    public void closeDriver() {
        Driver.destroy();
        LOGGER.info("Test finished");
    }

    @Given("I open booking site")
    public void openSite() {
        bookingMainPage.siteLoad();
        bookingMainPage.dismissInfo();
        LOGGER.debug("Step completed");
    }

    @When("I input the city")
    public void iInputThe() {
        bookingMainPage.findHotel("Berlin");
        LOGGER.debug("Step completed");
    }

    @And("Input dates")
    public void inputDates() {
        bookingMainPage.inputFirstDate(10, "May", 2023);
        bookingMainPage.inputSecondDate(18, "May", 2023);
        LOGGER.debug("Step completed");
    }

    @And("Input adults and rooms")
    public void inputAdultsAndRooms() {
        bookingMainPage.adultsInput();
        bookingMainPage.adultsInput();
        bookingMainPage.roomsInput();
        LOGGER.debug("Step completed");
    }

    @And("Click on button search")
    public void clickOnButtonSearch() {
        bookingMainPage.searchButtonClick();
        foundHotelsPage.spinnerWait();
        LOGGER.debug("Step completed");
    }

    @And("Sort the hotels")
    public void sortTheHotels() {
        foundHotelsPage.sortDropdownClick();
        foundHotelsPage.sortFromCheapest();
        LOGGER.debug("Step completed");
    }

    @Then("Check the cost of the night")
    public void checkTheCostOfTheNight() {
        String priceHotel = foundHotelsPage.getFirstHotelPrice().getText();
        String priceHotelNumberOnly = priceHotel.replaceAll("[^0-9]", "");
        String priceNight = foundHotelsPage.getPricePerNight().getText();
        String priceNightNumberOnly = priceNight.replaceAll("[^0-9]", "");
        double hotelPrice = Double.parseDouble(priceHotelNumberOnly);
        double nightPrice = Double.parseDouble(priceNightNumberOnly);
        Assert.assertTrue("the cost of a night in a hotel is less than the minimum", hotelPrice / 7 >= nightPrice);
        LOGGER.debug("Step completed");
    }
}
