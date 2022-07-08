package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
    }

    @After
    public void quitDriver() {
        System.out.println("***Webdriver is done.***");
        driver.quit();
    }
}