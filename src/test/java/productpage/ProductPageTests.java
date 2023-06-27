package productpage;

import basetest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;

public class ProductPageTests extends BaseTest {
    //автоматизированный тест-кейс №7
    @Test
    public void sendReviewOnModerationTest() {
        int rating = 3;
        String nickname = "Тестировщик";
        String summary = "Тестовое название";
        String review = "Тест";
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.clickButtonMenTopsBtn();
        ProductPage productPage = catalogPage.openFirstProductPage();
        productPage.fillAndSubmitNewReview(rating, nickname, summary, review);
        Assertions.assertTrue(productPage.checkForReviewSubmitSuccessMessage());
    }
}
