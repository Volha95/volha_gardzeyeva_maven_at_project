package classwork.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverWeather {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("погода минск", Keys.ENTER);
        driver.findElement(By.xpath("//div[@data-wob-di=\"1\"]")).click();
        WebElement el = driver.findElement(By.xpath("//*[contains(@aria-label, '12:00')]"));
        String str = el.getAttribute("aria-label");
        String[] array = str.split("Celsius");
        System.out.println(array[0] + " завтра в 12:00");
    }
}
