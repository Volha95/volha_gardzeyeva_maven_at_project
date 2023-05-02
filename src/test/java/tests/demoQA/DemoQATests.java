package tests.demoQA;

import classwork.day13.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import pages.demoQA.DemoQASelectPage;

public class DemoQATests {
    DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @Before
    public void openingSelectPage() {
        demoQASelectPage.goToSelectMenu();
    }

    @After
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
