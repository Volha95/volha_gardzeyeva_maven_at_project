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

import static org.openqa.selenium.By.xpath;

public class BookingWebDriverParisTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void dataCreation() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
        driver.findElement(xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
    }

    @Test
    public void hotelsSort() {
        driver.findElement(xpath("//input[@placeholder='Where are you going?']")).sendKeys("Париж");
        driver.findElement(xpath("//div[@data-testid='searchbox-dates-container']")).click();
        driver.findElement(xpath("//span[@aria-label='1 May 2023']")).click();
        driver.findElement(xpath("//span[@aria-label='8 May 2023']")).click();
        driver.findElement(xpath("//button[@data-testid='occupancy-config']")).click();
        WebElement elAdults = driver.findElement(xpath("//input[@id='group_adults']/following-sibling::div/button[2]"));
        elAdults.click();
        elAdults.click();
        driver.findElement(xpath("//input[@id='no_rooms']/following-sibling::div/button[2]")).click();
        driver.findElement(xpath("//span[text()='Search']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='price']")).click();
        WebElement priceHotelElement = driver.findElement(By.xpath("//span[@data-testid='price-and-discounted-price'][1]"));
        String priceHotel = priceHotelElement.getText();
        String priceHotelNumberOnly = priceHotel.replaceAll("[^0-9]", "");
        WebElement priceNightElement = driver.findElement(By.xpath("//div[@data-testid='filters-sidebar']/div[2]//div[@data-filters-item='pri:pri=5']"));
        String priceNight = priceNightElement.getText();
        String priceNightNumberOnly = priceNight.replaceAll("[^0-9]", "");
        double hotelPrice = Double.parseDouble(priceHotelNumberOnly);
        double nightPrice = Double.parseDouble(priceNightNumberOnly);
        Assert.assertTrue("the cost of a night in a hotel is less than the minimum", hotelPrice / 7 >= nightPrice);

    }

    @After
    public void driverClose() {
        driver.quit();
    }
}

