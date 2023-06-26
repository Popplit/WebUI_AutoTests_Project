package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Settings {
    public static WebDriver driver = new ChromeDriver();
    public static Actions actions = new Actions(driver);
}
