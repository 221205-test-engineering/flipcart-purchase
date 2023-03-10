package com.revature.runner;

import com.revature.pages.MainPage;
import com.revature.pages.SelectedProductPage;
import com.revature.pages.SignUpPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/revature/features/ProductPurchase.feature", glue="com.revature.steps")
public class PurchaseRunner{
    public static WebDriver driver;
    public static MainPage mainPage;
    public static SelectedProductPage selectedProductPage;
    public static SignUpPage signUpPage;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        selectedProductPage = new SelectedProductPage(driver);
        signUpPage = new SignUpPage(driver);
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
