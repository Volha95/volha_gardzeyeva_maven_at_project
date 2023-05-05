package pages;

import driver.Driver;
import org.openqa.selenium.By;

public class PreconditionMyMailbox {
    private final By INCOMING_MESSAGES = By.xpath("//a[@data-testid='unread-messages']");
    private final By FIRST_LETTER = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/a[1]");

    public void findEmail() {
        Driver.getWebDriver().get("https://mail.ru/");
        Driver.getWebDriver().findElement(INCOMING_MESSAGES).click();
        Driver.getWebDriver().findElement(FIRST_LETTER).click();

    }
}
