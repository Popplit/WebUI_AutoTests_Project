package test;

import configuration.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;


public class BaseTest extends Settings {

    protected BasePage basePage = new BasePage(createDriver());
    protected MainPage mainPage;
    protected CatalogPage catalogPage;
    protected ProductPage productPage;

    @BeforeEach
    void openWebSite() {
        mainPage = basePage.initDriver(URL);
    }

    @AfterEach
    void closeWebSite() {
        basePage.closeDriver();
    }

}
