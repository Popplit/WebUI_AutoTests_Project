package basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static configuration.Settings.driver;

public class BaseTest {
    @BeforeEach
    void openWebSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @AfterAll
    static void shutdownDriverSession() {
        driver.quit();
    }
}
