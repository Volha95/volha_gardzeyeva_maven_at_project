package pages.demoQA;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASelectPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(DemoQASelectPage.class.getName());

    private final By SELECT_OPTION = By.xpath("//div[@id='withOptGroup']");
    private final By GROUP1_OPTION2 = By.xpath("//div[text()='Group 1, option 2']");
    private final By SELECT_TITLE = By.xpath("//div[@id='selectOne']");
    private final By SELECT_MRS = By.xpath("//div[text()='Mrs.']");
    private final By OLD_SELECT_MENU = By.id("oldSelectMenu");
    private final By MULTISELECT = By.xpath("//div[text()='Select...']/..");
    private final By SELECT_BLUE = By.xpath("//div[text()='Blue']");
    private final By SELECT_CARS = By.id("cars");

    public void goToSelectMenu() {
        driver.get("https://demoqa.com/select-menu");
        LOGGER.trace("Go to demoqa site 'https://demoqa.com/select-menu'");
    }

    public void selectAnyValueOption() {
        driver.findElement(SELECT_OPTION).click();
        LOGGER.trace("Click on select option button, SELECT_OPTION locator: //div[@id='withOptGroup']");
        driver.findElement(GROUP1_OPTION2).click();
        LOGGER.trace("Click on option, GROUP1_OPTION2 locator: //div[text()='Group 1, option 2']");
    }
    public void selectAnyOneTitle() {
        driver.findElement(SELECT_TITLE).click();
        LOGGER.trace("Click on select title, SELECT_TITLE locator: //div[@id='selectOne']");
        driver.findElement(SELECT_MRS).click();
        LOGGER.trace("Click on SELECT_MRS element, locator: //div[text()='Mrs.']");
    }
    public WebElement selectOldMenu() {
        LOGGER.trace("Find old select menu element, OLD_SELECT_MENU locator By id: oldSelectMenu");
       return driver.findElement(OLD_SELECT_MENU);
    }
    public void selectMultiselect() {
        driver.findElement(MULTISELECT).click();
        LOGGER.trace("Click on multiselect menu, MULTISELECT locator: //div[text()='Select...']/..");
        driver.findElement(SELECT_BLUE).click();
        LOGGER.trace("Click on blue value in multiselect menu, SELECT_BLUE locator: //div[text()='Blue']");
    }
    public WebElement selectAnyCar() {
        LOGGER.trace("Find select cars element, SELECT_CARS locator By id: cars");
        return driver.findElement(SELECT_CARS);
    }

}
