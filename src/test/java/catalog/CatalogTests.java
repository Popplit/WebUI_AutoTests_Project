package catalog;

import configuration.Settings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static configuration.Settings.driver;

public class CatalogTests {

    @BeforeEach
    void openWebSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    void i() {
        WebElement menBtn = driver.findElement(By
                .cssSelector("a[href='https://magento.softwaretestingboard.com/men.html']"));
        Actions actions = new Actions(driver);
        menBtn.click();
        WebElement menTopsBtn = driver.findElement(By
                .cssSelector("li.item > a[href='https://magento.softwaretestingboard.com/men/tops-men.html']"));
        menTopsBtn.click();
        var products = driver.findElements(By.cssSelector(".item.product.product-item"));
        int expected = 12;
        int actual = products.size();
        Assertions.assertEquals(expected, actual);
    }

    @AfterAll
    static void closeSession() {
        driver.close();
    }
}
