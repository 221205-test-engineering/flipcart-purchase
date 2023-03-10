package com.revature.steps;

import com.revature.pages.MainPage;
import com.revature.pages.SelectedProductPage;
import com.revature.pages.SignUpPage;
import com.revature.runner.PurchaseRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPurchaseImpl {
     public WebDriver driver = PurchaseRunner.driver;
     MainPage mainPage = new MainPage(driver);
     SelectedProductPage selectedProductPage=new SelectedProductPage(driver);
     SignUpPage signUpPage = new SignUpPage(driver);

    @Given("User is in the flipcart website")
    public void user_is_in_the_flipcart_website() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
    }
    @When("User search for the product name with memory size")
    public void user_search_for_the_product_name(){
        mainPage.productSearch.sendKeys("iPhone14 plus purple 512 GB ");
        mainPage.productSearch.sendKeys(Keys.ENTER);

    }
    @When("User select the product")
    public void user_select_the_product() {
        signUpPage.Xclose.click(); // Sign in page closer
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                .visibilityOfAllElements(mainPage.listProducts));
        System.out.println(mainPage.listProducts.size());
        List<WebElement> list = mainPage.listProducts;
        list.get(0).click();

    }
    @When("User add product to the cart")
    public void user_add_product_to_the_cart() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(10000);
        selectedProductPage.addCart.click();


    }
//    @When("User select place the order")
//    public void user_select_place_the_order() {
//        selectedProductPage.buyNow.click();
//    }
//    @Then("Order should be reflected in the users my orders")
//    public void order_should_be_reflected_in_the_users_my_orders() {
//
//    }
}
