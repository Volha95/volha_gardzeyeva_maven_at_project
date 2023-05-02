package classwork.day12;

import classwork.day13.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class W3SchoolsWebDriverTest {
    WebDriver driver = Driver.getWebDriver();
    Actions make = new Actions(driver);

    @Before
    public void dataCreation() {
        driver.get("https://www.w3schools.com/java/");
    }

    @Test
    public void tutorialTest() {
        WebElement tutorial = driver.findElement(By.xpath("//span[text()='Tutorial']"));
        make.doubleClick(tutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        driver.navigate().to("https://www.google.com/");
        WebElement googleSearch = driver.findElement(By.xpath("//textarea[@role='combobox']"));
        make.click(googleSearch)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> allResults = driver.findElements(By.xpath("//h3"));
        List<WebElement> listOfElements = driver.findElements(By.xpath("//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL')]"));
        Assert.assertEquals("the result doesn't contain the word 'tutorial'", allResults.size(), listOfElements.size());
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}
