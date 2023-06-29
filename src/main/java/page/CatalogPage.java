package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BasePage {

    private final WebElement limiterList = new WebDriverWait(driver, Duration.ofSeconds(25))
            .until(ExpectedConditions.presenceOfElementLocated(By
                    .xpath("(//div[@class='field limiter'])[last()]")));
    private final Actions actions = new Actions(driver);
    WebElement nextPageBtn;
    private WebElement firstProductCardNameBtn = waitForElement("//li[@class='item product product-item'][1]//a[@class='product-item-link']");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage changeLimitOfProductsOnOnePage(int newLimitValue) {
        limiterList.click();
        List<WebElement> limiters = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='field limiter'])[last()]//option")));
        for (WebElement limit : limiters) {
            if (limit.getAttribute("label").contains(Integer.toString(newLimitValue))) {
                limit.click();
                break;
            }
        }
        return this;
    }

    public int getAmountOfProductsOnOnePage() {
        List<WebElement> productsOnPage = driver.findElements(By.cssSelector(".item.product.product-item"));

        return productsOnPage.size();
    }

    public boolean goToNextPage() {
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
        firstProductCardNameBtn.click();

        return new ProductPage(driver);
    }

    public String getFirstProductName() {
        return firstProductCardNameBtn.getText();
    }

    public boolean checkIfAmountsOfProductNotExceedingTheLimit(List<Integer> productAmounts, int expected) {

        for (int i = 0; i < productAmounts.size(); i++) {

            if (isProduct(productAmounts,expected,i) ||isProduct(productAmounts,expected,i) ) {
                return false;

            }
        }

        return true;
    }
     private boolean isProduct(List<Integer> productAmounts, int expected, int i) {
        return productAmounts.get(i) != expected & i < productAmounts.size() - 1;
     }
}
