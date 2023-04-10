package classwork.day11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://selenium.dev");
    }
}
