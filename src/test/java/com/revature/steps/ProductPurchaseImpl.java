package com.revature.steps;

import com.revature.pages.MainPage;
import com.revature.pages.PlaceOrderPage;
import com.revature.pages.SelectedProductPage;
import com.revature.pages.SignUpPage;
import com.revature.runner.PurchaseRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ProductPurchaseImpl {
     public WebDriver driver = PurchaseRunner.driver;
     MainPage mainPage = new MainPage(driver);
     SelectedProductPage selectedProductPage=new SelectedProductPage(driver);
     SignUpPage signUpPage = new SignUpPage(driver);

     PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);

    @Given("User is in the flipcart website opening page")
    public void user_is_in_the_flipcart_website() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
    }
    @When("User search for the product name with memory size")
    public void user_search_for_the_product_name(){
        mainPage.productSearch.sendKeys("iPhone13 plus");
        mainPage.productSearch.sendKeys(Keys.ENTER);

    }
    @When("User select the product")
    public void user_select_the_product() {
        signUpPage.Xclose.click(); // Sign in page closer
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .visibilityOfAllElements(mainPage.listProducts));
        System.out.println(mainPage.listProducts.size());

        String parent = driver.getWindowHandle();

        List<WebElement> list = mainPage.listProducts;
        list.get(0).click();

        // It will return the parent window name as a String
        Set<String> windows = driver.getWindowHandles();

        // Now iterate through the set
        for(String child : windows){
            if(!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
    }
    @When("User add product to the cart")
    public void user_add_product_to_the_cart() throws InterruptedException {
        Thread.sleep(5000);

        String url = driver.getCurrentUrl();
        System.out.println("URL: " + url);
        System.out.println(selectedProductPage.addCart.isEnabled());
        selectedProductPage.addCart.click();
        // Screanshot of element
        try {
            File scrFile = selectedProductPage.addCart.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./image.png"));
        }catch (IOException e){}

        selectedProductPage.cartIcon.click();

    }
    @When("User select place the order")
    public void user_select_place_the_order() throws InterruptedException {
        Thread.sleep(5000);
        placeOrderPage.placeOrder.click();


    }
    @Then("User should be in the Sign up or Sign in page")
    public void User_should_be_in_the_Sign_up_or_Sign_in_page() {
        assertEquals(signUpPage.loginPageHeader.getText(),"LOGIN OR SIGNUP");
//        System.exit(1);
    }
}
