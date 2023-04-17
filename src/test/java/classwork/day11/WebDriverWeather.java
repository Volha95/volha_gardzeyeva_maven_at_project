package classwork.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class WebDriverWeather {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("погода минск");
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        driver.findElement(By.xpath("//div[@data-wob-di='1']")).click();
        WebElement el = driver.findElement(By.xpath("//*[contains(@aria-label, '12:00')]"));
        String str = el.getAttribute("aria-label");
        String[] array = str.split("Celsius");
        driver.quit();
        System.out.println(array[0] + " завтра в 12:00");
    }
}
