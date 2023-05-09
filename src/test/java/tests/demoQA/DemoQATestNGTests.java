package tests.demoQA;

import driver.Driver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.Select;
import pages.demoQA.DemoQASelectPage;

public class DemoQATestNGTests {
    DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @BeforeMethod
    public void openingSelectPage() {
        demoQASelectPage.goToSelectMenu();
    }

    @AfterMethod
    public void closingPage() {
        Driver.destroy();
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
    }
}
