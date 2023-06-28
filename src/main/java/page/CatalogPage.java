package page;

import configuration.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static configuration.Settings.actions;
import static configuration.Settings.driver;

public class CatalogPage {

    private final WebElement limiterList = new WebDriverWait(driver, Duration.ofSeconds(25))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("(//div[@class='field limiter'])[last()]")));
    private final Actions actions = new Actions(driver);
    WebElement nextPageBtn;
    WebElement firstProductCardNameBtn;

    public void changeLimitOfProductsOnOnePage(int newLimitValue) {
        limiterList.click();
        List<WebElement> limiters = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='field limiter'])[last()]//option")));
        for (WebElement limit : limiters) {
            if (limit.getAttribute("label" ).contains(Integer.toString(newLimitValue))) {
                limit.click();
                break;
            }
        }
    }

    public int getAmountOfProductsOnOnePage() {
        List<WebElement> productsOnPage = driver.findElements(By.cssSelector(".item.product.product-item"));

        return productsOnPage.size();
    }

    public boolean goToNextPage(){
        try {
            nextPageBtn = (new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//li[contains(@class, 'pages-item-next')]")))).get(1);
        } catch (TimeoutException e) {
            return false;
        }

        nextPageBtn.click();

        return true;
    }

    public List<Integer> getAmountOfProductsFromAllPages() {
        List<Integer> productAmounts = new ArrayList<>();
        do {
            productAmounts.add(getAmountOfProductsOnOnePage());
        } while (goToNextPage());

        return productAmounts;
    }

    public ProductPage openFirstProductPage() {
         firstProductCardNameBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//li[@class='item product product-item'][1]//a[@class='product-item-link']")));
        firstProductCardNameBtn.click();

        return new ProductPage();
    }
    public String getFirstProductName() {
        firstProductCardNameBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//li[@class='item product product-item'][1]//a[@class='product-item-link']")));
        return firstProductCardNameBtn.getText();

    }

    public boolean checkIfAmountsOfProductNotExceedingTheLimit(List<Integer> productAmounts, int expected) {
        for (int i = 0; i < productAmounts.size(); i++) {
            if (productAmounts.get(i) != expected & i < productAmounts.size()-1 ||
                    i == productAmounts.size()-1 & productAmounts.get(i) > expected) {
                return false;
            }
        }
        return true;
    }
}
