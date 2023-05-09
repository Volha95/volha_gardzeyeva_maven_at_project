package tests.demoQA;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.Select;
import pages.demoQA.DemoQASelectPage;

public class DemoQATestNGTests {
    private static final Logger LOGGER = Logger.getLogger(DemoQATestNGTests.class.getName());
    DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @BeforeMethod
    public void openingSelectPage() {
        LOGGER.info("Test started");
        demoQASelectPage.goToSelectMenu();
    }

    @AfterMethod
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
