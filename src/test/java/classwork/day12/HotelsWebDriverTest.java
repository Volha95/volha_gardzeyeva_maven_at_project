package classwork.day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HotelsWebDriverTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void dataCreation() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkHotels() {
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Where are you going?']")).sendKeys("Berlin");
        driver.findElement(By.xpath("//div[text()='Berlin']")).click();
        driver.findElement(By.xpath("//span[@aria-label='2 May 2023']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 May 2023']")).click();
        driver.findElement(By.xpath("//span[text()='Search']")).click();
        WebElement propertiesFound = driver.findElement(By.xpath("//h1[contains(text(), 'properties')]"));
        String number = propertiesFound.getText();
        String numberOnly = number.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(numberOnly);
        Assert.assertNotEquals("There are no hotels for the entered dates", 0, i);
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}
