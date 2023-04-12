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
        WebElement element = driver.findElement(By.name("q"));

//        element.sendKeys("погода минск");
//        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();

        element.sendKeys("погода минск", Keys.ENTER);
        driver.findElement(By.xpath("//div[@aria-label='чацвер']")).click();
        WebElement el = driver.findElement(By.xpath("//*[contains(@aria-label, '9°Celsius чацвер 12:00')]"));
        String str = el.getText();
        System.out.println(str + "° в 12:00");
    }
}
