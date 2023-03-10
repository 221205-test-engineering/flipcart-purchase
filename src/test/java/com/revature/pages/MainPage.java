package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Main page product guest product search input field
    @FindBy(className = "_3704LK")
    public WebElement productSearch;

    // Main page product search submit button locator
    @FindBy(className = "L0Z3Pu")
    public WebElement submitButton;

    // Whole listed product locator
//    @FindBy(className = "_1YokD2 _3Mn1Gg")
//    public List<WebElement> allProducts;

    // All the product locator with Name, Color, ROM
    @FindBy(className = "_4rR01T")
    public List<WebElement> listProducts;

    //Selected product click button
    @FindBy(className = "_396cs4")
    public WebElement selectProduct;
}
