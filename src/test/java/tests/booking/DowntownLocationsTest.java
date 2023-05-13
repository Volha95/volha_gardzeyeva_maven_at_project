package tests.booking;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.booking.BookingMainPage;

public class DowntownLocationsTest {
    private static final Logger LOGGER = Logger.getLogger(DowntownLocationsTest.class.getName());
    BookingMainPage bookingMainPage = new BookingMainPage();

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
    public void verifyLocations() {
//        bookingMainPage.loginClick();
        bookingMainPage.goToCarRent();

    }
}
