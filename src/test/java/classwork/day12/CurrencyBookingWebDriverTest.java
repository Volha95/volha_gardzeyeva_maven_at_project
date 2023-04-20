package classwork.day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class CurrencyBookingWebDriverTest {
    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);

    @Before
    public void dataCreation() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.get("https://www.booking.com/");
        driver.findElement(xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
    }

    @Test
    public void checkingTooltipCurrency() {
        WebElement elementCur = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));
        actions.moveToElement(elementCur);
        actions.perform();
        WebElement actualCurrencyTooltipElement = driver.findElement(By.xpath("//div[text()='Select your currency']"));
        Assert.assertEquals("Tooltip value not as expected", "Select your currency", actualCurrencyTooltipElement.getText());

    }

    @Test
    public void checkingTooltipLanguage() {
        WebElement elementLang = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        actions.moveToElement(elementLang);
        actions.perform();
        WebElement actualLanguageTooltipElement = driver.findElement(By.xpath("//div[text()='Select your language']"));
        Assert.assertEquals("Tooltip value not as expected", "Select your language", actualLanguageTooltipElement.getText());
    }

    @After
    public void driverExit() {
        driver.quit();
    }
}

