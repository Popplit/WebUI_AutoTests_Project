package test.productPage;

import test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;

public class ProductPageTest extends BaseTest {
    //автоматизированный тест-кейс №7
    @Test
    public void sendReviewOnModerationTest() {
        int rating = 5;
        String nickname = "Тестировщик";
        String summary = "Тестовое название";
        String review = "Тест";
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.clickMenTopsBtn();
        ProductPage productPage = catalogPage.openFirstProductPage();
        productPage.fillAndSubmitNewReview(rating, nickname, summary, review);
        Assertions.assertTrue(productPage.checkForReviewSubmitSuccessMessage());
    }
}
