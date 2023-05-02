package classwork.day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        return switch (config != null ? config : Config.CHROME) {
            case FF -> getFFDriver();
            case EDGE -> getEdgeDriver();
            default -> getChromeDriver();
        };
    }


    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        caps.addArguments("disable-infobars");
        caps.addArguments("disable-popup-blocking");
        caps.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        return new ChromeDriver(caps);
    }

    private static WebDriver getEdgeDriver() {
        return null;
    }

    private static WebDriver getFFDriver() {
        return null;
    }

}
