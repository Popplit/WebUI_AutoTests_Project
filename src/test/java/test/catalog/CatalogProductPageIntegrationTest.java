package test.catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogProductPageIntegrationTest extends BaseTest {

    @Test
    void transitionFromCatalogFirstProductCardToItsProductPageTest() {

        catalogPage                 = mainPage.clickMenTopsBtn();
        String firstProductCardName = catalogPage.getFirstProductName();
        productPage                 = catalogPage.openFirstProductPage();
        String productPageTitleName = productPage.getProductName();

        assertEquals(firstProductCardName, productPageTitleName);
    }
}
