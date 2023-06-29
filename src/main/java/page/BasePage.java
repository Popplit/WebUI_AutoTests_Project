package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public MainPage initDriver(String url) {
        driver.get(url);

        return new MainPage(driver);
    }

    public void closeDriver() {
        driver.quit();
    }



    public WebElement waitForElement(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath(xpath)));
    }
}
