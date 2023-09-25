package com.madgical.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement elem) {
        elem.click();
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }


    public List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    public String getText(WebElement elem) {
        return elem.getText();
    }

    public String getText(By locator) {

            waitForElementToBePresent(locator);
            WebElement element = driver.findElement(locator);
            return element.getText();

    }

    public void waitForElementToBeVisible(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElementToBePresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void back() {
        driver.navigate().back();
    }

    public void type(WebElement elem, String text) {
        elem.sendKeys(text);
    }

    public boolean clickElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            waitForElementToBePresent(locator);
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clearText(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendKeys(By locator, String text) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert().getText();
        } catch (Exception e) {
            return null;
        }
    }
}
