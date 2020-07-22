package com.xander.selenium.pages.gitlab;

import com.xander.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitlabLogin extends PageObject {

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement tfd_username;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement tfd_password;

    @FindBy(xpath = "//input[@data-qa-selector=\"sign_in_button\"]")
    private WebElement btn_login;

    public GitlabLogin(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtn_login(){
        return btn_login;
    }

    public void login(String username, String password){
        tfd_username.sendKeys(username);
        tfd_password.sendKeys(password);
    }
}
