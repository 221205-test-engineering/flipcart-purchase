package com.revature.steps;

import com.revature.pages.SignUpPage;
import com.revature.runner.PurchaseRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class SignUPImpl {

    public WebDriver driver = PurchaseRunner.driver;
    public SignUpPage signUpPage = new SignUpPage(driver);
    // Step Defenitions
    @Then("A new login page opens")
    public void a_new_login_page_opens() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(signUpPage.newUser.getText());
        assertEquals(signUpPage.newUser.getText(),"New to Flipkart? Create an account");
    }

    @When("User clicks create an account button")
    public void user_clicks_create_an_account_button() {
        signUpPage.newUser.click();
    }

    @Then("Looks like you are new here page opens")
    public void looks_like_you_are_new_here_page_opens() {
       assertEquals(signUpPage.newHere.getText(), "Looks like you're new here!");
    }

    @When("User entered his phone number")
    public void user_entered_his_phone_number() {
        signUpPage.phoneNumber.sendKeys("1122233344");
    }

    @When("User clicks continue button")
    public void user_clicks_continue_button() {
        signUpPage.signUpContinue.click();
    }

    @Then("Invalid mobile number message appears")
    public void Invalid_mobile_no_message_appears() {
        assertEquals(signUpPage.invalidNo.getText(),"Please enter a valid Mobile number");
    }

}
