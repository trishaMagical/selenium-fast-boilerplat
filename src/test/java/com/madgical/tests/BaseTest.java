package com.madgical.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext context) {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }


}
