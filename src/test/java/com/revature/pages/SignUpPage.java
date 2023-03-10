package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public WebDriver driver;
    public SignUpPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login page title
    @FindBy(className = "_1aULyb")
    public WebElement loginPageHeader;

    // Login/SignUp email input field locator
    @FindBy(xpath = "//div[@class='_1XHoKS']/form//div/input")
    public WebElement email;

    //phone number input field locator for login or signup
    @FindBy(xpath = "//div[@class='_1XHoKS']/form/div/input")
    public WebElement phone;

    //OTP input field locator
    @FindBy(xpath = "//div[@class = '_1XHoKS']/form/div/input")
    public WebElement OTP;

    // Sign in closing button
    @FindBy(xpath = "//div[@class = '_2QfC02']/button")
    public WebElement Xclose;
}
