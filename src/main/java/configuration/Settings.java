package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Settings {
    private static WebDriver driver;
    public static String URL = "https://magento.softwaretestingboard.com/";

    public static WebDriver createDriver(){
        driver = new ChromeDriver();
        return driver;
    }

}