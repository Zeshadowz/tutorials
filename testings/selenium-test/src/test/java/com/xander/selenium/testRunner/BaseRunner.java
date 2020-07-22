package com.xander.selenium.testRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BaseRunner {
    WebDriver driver;

    public void waitForElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForWebElement(By locator) {
        Wait<WebDriver> wait = getWait();

        return wait.until(webDriver -> webDriver.findElement(locator));
    }

    // Waiting 30 seconds for an element to be present on the page, checking
    // for its presence once every 5 seconds.
    private Wait<WebDriver> getWait() {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));
    }
}
