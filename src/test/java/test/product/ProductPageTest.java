package test.product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CatalogPage;
import page.MainPage;
import page.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest extends BaseTest {

    @ParameterizedTest(name = "Отправка отзыва")
    @CsvSource({"5, Тестировщик, Тестовое название, Тест"})
    public void sendReviewOnModerationTest(int rating, String nickname, String summary, String review) {

        catalogPage = mainPage.clickMenTopsBtn();
        productPage = catalogPage.openFirstProductPage();
        productPage.fillAndSubmitNewReview(rating, nickname, summary, review);

        assertTrue(productPage.checkForReviewSubmitSuccessMessage());
    }
}
