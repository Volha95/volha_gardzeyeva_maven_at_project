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
    }

    public void selectAnyValueOption() {
        driver.findElement(SELECT_OPTION).click();
        driver.findElement(GROUP1_OPTION2).click();
    }
    public void selectAnyOneTitle() {
        driver.findElement(SELECT_TITLE).click();
        driver.findElement(SELECT_MRS).click();
    }
    public WebElement selectOldMenu() {
       return driver.findElement(OLD_SELECT_MENU);
    }
    public void selectMultiselect() {
        driver.findElement(MULTISELECT).click();
        driver.findElement(SELECT_BLUE).click();
    }
    public WebElement selectAnyCar() {
        return driver.findElement(SELECT_CARS);
    }

}
