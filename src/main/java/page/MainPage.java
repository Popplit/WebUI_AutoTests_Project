package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class MainPage {
    public static WebElement menBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-5']")));
    public static WebElement menTopsBtn =new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-17']")));

    public static void clickButtonMenTopsBtn(){
        actions.moveToElement(menBtn).pause(Duration.ofSeconds(1)).click(menTopsBtn).perform();
    }
}
