package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.Settings.driver;

public class BaseTest {
//    @BeforeAll
//    static void initializeNewDriver() {
//        driver = new ChromeDriver();
//    }
    @BeforeEach
    void openWebSite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }
//    @AfterAll
//     static void shutdownDriverSession() {
//        driver.close();
//    }
}
