package catalog;

import com.sun.tools.javac.Main;
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
import page.MainPage;

import java.time.Duration;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class CatalogTests {

    @BeforeEach
    void openWebSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    void maxCountOfProductsOnOnePageTest() {
        MainPage.clickButtonMenTopsBtn();
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
