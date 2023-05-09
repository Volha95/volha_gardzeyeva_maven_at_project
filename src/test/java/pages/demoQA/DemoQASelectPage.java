package pages.demoQA;

import classwork.day11.WebDriverWeather;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoQASelectPage {
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
        Driver.getWebDriver().get("https://demoqa.com/select-menu");
    }

    public void selectAnyValueOption() {
        Driver.getWebDriver().findElement(SELECT_OPTION).click();
        Driver.getWebDriver().findElement(GROUP1_OPTION2).click();
    }
    public void selectAnyOneTitle() {
        Driver.getWebDriver().findElement(SELECT_TITLE).click();
        Driver.getWebDriver().findElement(SELECT_MRS).click();
    }
    public WebElement selectOldMenu() {
       return Driver.getWebDriver().findElement(OLD_SELECT_MENU);
    }
    public void selectMultiselect() {
        Driver.getWebDriver().findElement(MULTISELECT).click();
        Driver.getWebDriver().findElement(SELECT_BLUE).click();
    }
    public WebElement selectAnyCar() {
        return Driver.getWebDriver().findElement(SELECT_CARS);
    }

}
