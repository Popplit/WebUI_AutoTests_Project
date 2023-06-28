package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class MainPage {
    private final WebElement menBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='ui-id-5']")));
    private final WebElement menTopsBtn =new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='ui-id-17']")));
    private final WebElement womenBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='ui-id-4']")));
    private final WebElement womenTopsBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='ui-id-9']")));

    public CatalogPage clickMenTopsBtn(){
        actions.moveToElement(menBtn).pause(Duration.ofSeconds(1)).click(menTopsBtn).perform();

        return new CatalogPage();
    }

    public CatalogPage clickWomenTopsBtn(){
        actions.moveToElement(womenBtn).pause(Duration.ofSeconds(1)).click(womenTopsBtn).perform();

        return new CatalogPage();
    }
}
