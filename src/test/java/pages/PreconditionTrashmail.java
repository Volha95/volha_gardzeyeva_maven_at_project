package pages;

import classwork.day13.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreconditionTrashmail {
    WebDriver driver = Driver.getWebDriver();

    public void emailCreation() {
        driver.get("https://trashmail.com/");
        driver.findElement(By.xpath("//input[@id='fe-mob-forward']")).sendKeys("olga.gordeeva00@inbox.ru");
        driver.findElement(By.xpath("//select[@id='fe-mob-fwd-nb']")).click();
        driver.findElement(By.xpath("//select[@id='fe-mob-fwd-nb']/option[@value='1']")).click();
        driver.findElement(By.xpath("//select[@id='fe-mob-life-span']")).click();
        driver.findElement(By.xpath("//select[@id='fe-mob-life-span']/option[@value='1']")).click();
        driver.findElement(By.xpath("//button[@id='fe-mob-submit']")).click();


    }
}
