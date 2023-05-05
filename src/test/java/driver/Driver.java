package driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    public static Config config;

    public static void setTimeouts(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(seconds));
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = DriverManager.getDriver(config);
            setTimeouts(20);
        }
        return driver;
    }

    public static void destroy() {
        driver.quit();
    }

    public static void close() {
        driver.close();
    }
}
