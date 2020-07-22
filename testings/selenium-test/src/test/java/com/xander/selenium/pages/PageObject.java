package com.xander.selenium.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return.document.readyState").toString().equals("complete");
            }
        };

        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
        } catch (InterruptedException e) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void waitForLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                return ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(expectedCondition);
    }
}
