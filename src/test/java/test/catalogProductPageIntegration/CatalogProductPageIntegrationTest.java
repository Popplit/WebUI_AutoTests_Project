package test.catalogProductPageIntegration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;
import test.BaseTest;

public class CatalogProductPageIntegrationTest extends BaseTest {
    //автоматизированный тест-кейс №9
    @Test
    void transitionFromCatalogFirstProductCardToItsProductPageTest() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.clickMenTopsBtn();
        String firstProductCardName = catalogPage.getFirstProductName();
        ProductPage productPage = catalogPage.openFirstProductPage();
        String productPageTitleName = productPage.getProductName();
        Assertions.assertEquals(firstProductCardName, productPageTitleName);
    }
}
