package catalog;

import basetest.BaseTest;
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
import page.CatalogPage;
import page.MainPage;

import java.time.Duration;
import java.util.List;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class CatalogTests extends BaseTest {
    //автоматизированный тест-кейс №4
    @Test
    void maxLimitOfProductsOnAllPagesTest() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.clickButtonWomenTopsBtn();
        int expected = 36;
        catalogPage.changeLimitOfProductsOnOnePage(expected);
        List<Integer> productAmounts = catalogPage.getAmountOfProductsFromAllPages();
        for (int i = 0; i < productAmounts.size(); i++) {
            Assertions.assertTrue(productAmounts.get(i) == expected ||
                    i == productAmounts.size()-1 & productAmounts.get(i) <= expected);
        }
    }

}
