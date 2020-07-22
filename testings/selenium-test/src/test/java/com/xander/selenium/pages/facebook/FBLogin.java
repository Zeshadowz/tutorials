package com.xander.selenium.pages.facebook;

import com.xander.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBLogin extends PageObject {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement tfdUsername;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement tfdPassword;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement tfdSubmit;

    public FBLogin(WebDriver driver) {
        super(driver);
    }

    public void proceedLogin(String username, String password){
        tfdUsername.sendKeys(username);
        tfdPassword.sendKeys(password);
    }
}
