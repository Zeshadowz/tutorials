package com.xander.selenium;

import com.xander.selenium.pages.facebook.FBLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Flipkart {

    WebDriver driver;
    FBLogin fbLogin;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/azangue/workspace/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to("https://www.facebook.com/");

        fbLogin = new FBLogin(driver);
    }

    @Test
    public void login(){
        fbLogin.proceedLogin("kevinromuald@hotmail.com", "$Christel78");
    }


}
