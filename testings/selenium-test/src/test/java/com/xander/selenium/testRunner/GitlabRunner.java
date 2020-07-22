package com.xander.selenium.testRunner;

import com.xander.selenium.pages.gitlab.GitlabHome;
import com.xander.selenium.pages.gitlab.GitlabLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitlabRunner extends BaseRunner {

    private static final String URL = "https://www.gitlab.com";

    //WebDriver driver;
    GitlabHome gitlabHome;
    GitlabLogin gitlabLogin;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/azangue/workspace/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to(URL);
        gitlabHome = new GitlabHome(driver);
    }

    @Test
    public void goToLoginPage(){
        gitlabHome.navigateToLogin();
        gitlabLogin = new GitlabLogin(driver);

        waitForElement(gitlabLogin.getBtn_login());
    }

    @Test
    public void loginToGitlab(){
        String url = driver.getCurrentUrl();
        System.out.println(url);
        gitlabLogin.login("kevinromuald@gmail.com", "password");
    }
}
