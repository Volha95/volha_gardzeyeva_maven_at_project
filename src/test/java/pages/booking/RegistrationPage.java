package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import pages.trashmail.TrashmailPage;

public class RegistrationPage {
    private final By EMAIL_INPUT_FIELD = By.id("username");
    private final By CONTINUE = By.xpath("//div[@class='hidden-password-input-container']/following-sibling::div/button[1]");
    private final By NEW_PASSWORD_FIELD = By.xpath("//input[@id='new_password']");
    private final By CONFIRMED_PASSWORD = By.xpath("//input[@id='confirmed_password']");
    private final By CREATE_ACCOUNT_BUTTON = By.xpath("//form[@class='nw-register']/button");

    public void registration() {
        Driver.getWebDriver().findElement(EMAIL_INPUT_FIELD).sendKeys(TrashmailPage.emailCreation());
        Driver.getWebDriver().findElement(CONTINUE).click();
        Driver.getWebDriver().findElement(NEW_PASSWORD_FIELD).sendKeys("Newpassword123");
        Driver.getWebDriver().findElement(CONFIRMED_PASSWORD).sendKeys("Newpassword123");
        Driver.getWebDriver().findElement(CREATE_ACCOUNT_BUTTON).click();


    }
}
