package pages.booking;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.trashmail.TrashmailPage;

public class RegistrationPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(RegistrationPage.class.getName());
    private final By EMAIL_INPUT_FIELD = By.id("username");
    private final By CONTINUE = By.xpath("//div[@class='hidden-password-input-container']/following-sibling::div/button[1]");
    private final By NEW_PASSWORD_FIELD = By.xpath("//input[@id='new_password']");
    private final By CONFIRMED_PASSWORD = By.xpath("//input[@id='confirmed_password']");
    private final By CREATE_ACCOUNT_BUTTON = By.xpath("//form[@class='nw-register']/button");

    public void registration() {
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(TrashmailPage.emailCreation());
        LOGGER.trace("Input email to email field, EMAIL_INPUT_FIELD locator By id: username");
        driver.findElement(CONTINUE).click();
        LOGGER.trace("Click on button CONTINUE, locator: //div[@class='hidden-password-input-container']/following-sibling::div/button[1]");
        driver.findElement(NEW_PASSWORD_FIELD).sendKeys("Newpassword123");
        LOGGER.trace("Input password to first password field, NEW_PASSWORD_FIELD locator: //input[@id='new_password']");
        driver.findElement(CONFIRMED_PASSWORD).sendKeys("Newpassword123");
        LOGGER.trace("Input password to second password field, CONFIRMED_PASSWORD locator: //input[@id='confirmed_password']");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        LOGGER.trace("Click on create account button, CREATE_ACCOUNT_BUTTON locator: //form[@class='nw-register']/button");
    }
}
