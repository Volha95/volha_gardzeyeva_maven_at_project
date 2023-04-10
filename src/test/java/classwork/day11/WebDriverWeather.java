package classwork.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWeather {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("погода минск");
        element.findElement(By.cssSelector("div span"));
        element.click();

    }
}
