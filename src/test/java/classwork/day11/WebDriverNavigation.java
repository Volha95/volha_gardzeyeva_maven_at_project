package classwork.day11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://ya.ru/");
        driver.navigate().back();
        driver.navigate().refresh();
    }
}
