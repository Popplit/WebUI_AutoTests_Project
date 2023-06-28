package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class ProductPage {

    private final WebElement productPageTitle = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@class='page-title']//span")));
    private final WebElement reviewsBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//a[@id='tab-label-reviews-title']")));
    private final WebElement nicknameField = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='nickname_field']")));
    private final WebElement summaryField = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='summary_field']")));
    private final WebElement reviewField = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='review_field']")));
    private final WebElement submitReviewBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("//*[@id='review-form']/div/div/button")));
    public void fillAndSubmitNewReview(int rating, String nickname, String summary, String review) {
        reviewsBtn.click();
        starRatingClick(rating);
        nicknameField.sendKeys(nickname);
        summaryField.sendKeys(summary);
        reviewField.sendKeys(review);
        submitReviewBtn.click();
    }
    public void starRatingClick(int rating) {
        WebElement starRatingReviewBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id='Rating_"+rating+"_label']")));
        int starRatingReviewBtnWidth = Integer.parseInt(starRatingReviewBtn.getAttribute("clientWidth"));
        double xOffSet = Math.ceil(starRatingReviewBtnWidth*(1/rating));
        actions.moveToElement(starRatingReviewBtn, (int)xOffSet, 0).click().perform();
    }
    public boolean checkForReviewSubmitSuccessMessage() {
        WebElement reviewSubmitSuccessMessage = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@data-ui-id='message-success']")));
        return reviewSubmitSuccessMessage.isDisplayed();
    }
    public String getProductName() {
        return productPageTitle.getText();
    }
}
