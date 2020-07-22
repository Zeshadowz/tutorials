package com.xander.selenium.pages.gitlab;

import com.xander.selenium.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitlabHome extends PageObject {

    public static final String URL = "https://www.gitlab.com/";

    @FindBy(partialLinkText = "Sign in")
    private WebElement signIn;

    public GitlabHome(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin(){
        signIn.click();
    }
}