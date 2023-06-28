package configuration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Settings {
    public static WebDriver driver = new ChromeDriver((ChromeOptions) new ChromeOptions().setPageLoadStrategy(PageLoadStrategy.NORMAL));
    public static Actions actions = new Actions(driver);

}
