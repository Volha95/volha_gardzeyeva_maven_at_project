package pages;

import classwork.day13.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreconditionMyMailbox {
    WebDriver driver = Driver.getWebDriver();

    public void findEmail() {
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("")).click();
    }
}
