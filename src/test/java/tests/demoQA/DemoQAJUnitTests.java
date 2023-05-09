package tests.demoQA;

import driver.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import pages.demoQA.DemoQASelectPage;


public class DemoQAJUnitTests {
    private static final Logger LOGGER = Logger.getLogger(DemoQAJUnitTests.class.getName());
    DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @Before
    public void openingSelectPage() {
        LOGGER.info("Test started");
        demoQASelectPage.goToSelectMenu();
    }

    @After
    public void closingPage() {
        Driver.destroy();
        LOGGER.info("Test finished");
    }

    @Test
    public void selectOptions() {
        demoQASelectPage.selectAnyValueOption();
        demoQASelectPage.selectAnyOneTitle();
        Select selectColor = new Select(demoQASelectPage.selectOldMenu());
        selectColor.selectByValue("3");
        demoQASelectPage.selectMultiselect();
        Select selectCars = new Select(demoQASelectPage.selectAnyCar());
        selectCars.selectByIndex(2);
        LOGGER.debug("Test passed");
    }
}
