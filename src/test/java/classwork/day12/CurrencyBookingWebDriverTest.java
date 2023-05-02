package classwork.day12;

import classwork.day13.Driver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CurrencyBookingWebDriverTest {
    WebDriver driver = Driver.getWebDriver();
    Actions actions = new Actions(driver);

    @Before
    public void dataCreation() {
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkingTooltipCurrency() {
        driver.findElement(By.xpath("//button[contains(@aria-label, 'Dismiss sign-in info.') or contains(@aria-label, 'Скрыть меню входа в аккаунт.')]")).click();
        WebElement elementCur = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));
        actions.moveToElement(elementCur);
        actions.perform();
        WebElement actualCurrencyTooltipElement = driver.findElement(By.xpath("//div[text()='Select your currency']"));
        Assert.assertTrue("tooltip isn't displayed", actualCurrencyTooltipElement.isDisplayed());
    }

    @Test
    public void checkingTooltipLanguage() {
        WebElement elementLang = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        actions.moveToElement(elementLang);
        actions.perform();
        WebElement actualLanguageTooltipElement = driver.findElement(By.xpath("//div[text()='Select your language']"));
        Assert.assertTrue("tooltip isn't displayed" ,actualLanguageTooltipElement.isDisplayed());
        driver.quit();
    }
}

