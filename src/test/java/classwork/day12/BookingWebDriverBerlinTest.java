package classwork.day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class BookingWebDriverBerlinTest {
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
    public void makeRedTitle() {
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Where are you going?']")).sendKeys("Berlin");
        driver.findElement(By.xpath("//div[text()='Berlin']")).click();
        driver.findElement(xpath("//span[text()='Search']")).click();
        WebElement hotel10 = driver.findElement(By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotel10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotel10);
        WebElement title = driver.findElement(By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]//div[@data-testid='title']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", title);
        WebElement redElement = driver.findElement(By.xpath("//div[@class='hotellist_wrap tracked shorten_property_block']//div[@data-testid='property-card'][10]//div[@style='color: red;']"));
        String str = redElement.getAttribute("style");
        Assert.assertEquals("hotel name isn't red", "color: red;", str);
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}
