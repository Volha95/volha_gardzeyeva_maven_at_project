package classwork.day12;

import classwork.day13.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class DemoQAWebDriverTest {
    WebDriver driver = Driver.getWebDriver();

    @Before
    public void dataCreation() {
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void selectOptions() {
        driver.findElement(By.xpath("//div[@id='withOptGroup']")).click();
        driver.findElement(By.xpath("//div[text()='Group 1, option 2']")).click();
        driver.findElement(By.xpath("//div[@id='selectOne']")).click();
        driver.findElement(By.xpath("//div[text()='Mrs.']")).click();
        Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));
        selectColor.selectByValue("3");
        driver.findElement(By.xpath("//div[text()='Select...']/..")).click();
        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        Select selectCars = new Select(driver.findElement(By.id("cars")));
        selectCars.selectByIndex(2);
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}
