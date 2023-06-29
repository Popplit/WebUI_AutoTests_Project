package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement menBtn = waitForElement("//*[@id='ui-id-5']");
    private final WebElement menTopsBtn = waitForElement("//*[@id='ui-id-17']");
    private final WebElement womenBtn = waitForElement("//*[@id='ui-id-4']");
    private final WebElement womenTopsBtn = waitForElement("//*[@id='ui-id-9']");

    public CatalogPage clickMenTopsBtn() {
        actions.moveToElement(menBtn).pause(Duration.ofSeconds(1)).click(menTopsBtn).perform();

        return new CatalogPage(driver);
    }

    public CatalogPage clickWomenTopsBtn() {
        actions.moveToElement(womenBtn).pause(Duration.ofSeconds(1)).click(womenTopsBtn).perform();

        return new CatalogPage(driver);
    }
}
