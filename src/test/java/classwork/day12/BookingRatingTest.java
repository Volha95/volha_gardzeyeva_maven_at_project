package classwork.day12;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BookingRatingTest {
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
    public void hotelRatingMax() {
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Where are you going?']")).sendKeys("Berlin");
        driver.findElement(By.xpath("//div[text()='Berlin']")).click();
        driver.findElement(By.xpath("//span[text()='Search']")).click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[text()='Property rating (high to low)']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='title']")).click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        String oldTab = driver.getWindowHandle();
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        WebElement scoreElement = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Scored')]"));
        double score = Double.parseDouble(scoreElement.getText());
        Assert.assertTrue("hotel rating less than 9", score >= 9.0);
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}
