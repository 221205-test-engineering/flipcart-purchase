package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductPage {
    public WebDriver driver;
    public SelectedProductPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//  Add product to the cart button
    @FindBy(xpath = "//*[@id=\"container\"]//div[3]/div[1]/div[1]/div[2]//li[1]/button")
    public WebElement addCart;

//    // Product order locator
//    @FindBy(className = "_2KpZ6l _2U9uOA ihZ75k _3AWRsL")
//    public WebElement buyNow;
//
}
