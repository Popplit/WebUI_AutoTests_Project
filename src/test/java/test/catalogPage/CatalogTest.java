package test.catalogPage;

import test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;

import java.util.List;

public class CatalogTest extends BaseTest {
    //автоматизированный тест-кейс №4
    @Test
    void maxLimitOfProductsOnAllPagesTest() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.clickWomenTopsBtn();
        int expected = 36;
        catalogPage.changeLimitOfProductsOnOnePage(expected);
        List<Integer> productAmounts = catalogPage.getAmountOfProductsFromAllPages();
        Assertions.assertTrue(catalogPage.checkIfAmountsOfProductNotExceedingTheLimit(productAmounts, expected));
    }

}
