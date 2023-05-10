package steps;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.Select;
import pages.demoQA.DemoQASelectPage;

public class DemoQACucumberTests {
    private static final Logger LOGGER = Logger.getLogger(DemoQACucumberTests.class.getName());
    DemoQASelectPage demoQASelectPage = new DemoQASelectPage();
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
    @Given("I open demoQA-select page")
    public void openSite() {
        demoQASelectPage.goToSelectMenu();
        LOGGER.debug("Step completed");
    }

    @When("I select value")
    public void selectValue() {
        demoQASelectPage.selectAnyValueOption();
        LOGGER.debug("Step completed");
    }

    @And("I select one")
    public void selectOne() {
        demoQASelectPage.selectAnyOneTitle();
        LOGGER.debug("Step completed");
    }

    @And("I select old style select")
    public void selectOldStyleSelect() {
        Select selectColor = new Select(demoQASelectPage.selectOldMenu());
        selectColor.selectByValue("3");
        LOGGER.debug("Step completed");
    }

    @And("I select multiselect drop down")
    public void selectMultiselectDropDown() {
        demoQASelectPage.selectMultiselect();
        LOGGER.debug("Step completed");
    }

    @Then("I select standard multi select")
    public void selectStandardMultiSelect() {
        Select selectCars = new Select(demoQASelectPage.selectAnyCar());
        selectCars.selectByIndex(2);
        LOGGER.debug("Step completed");
    }
}
