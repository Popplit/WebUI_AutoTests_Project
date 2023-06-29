package test.catalog;

import test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest extends BaseTest {

    @Test
    void maxLimitOfProductsOnAllPagesTest() {
        int expected = 36;

        catalogPage                  = mainPage.clickWomenTopsBtn().changeLimitOfProductsOnOnePage(expected);
        List<Integer> productAmounts = catalogPage.getAmountOfProductsFromAllPages();

        assertTrue(catalogPage.checkIfAmountsOfProductNotExceedingTheLimit(productAmounts, expected));
    }

}
