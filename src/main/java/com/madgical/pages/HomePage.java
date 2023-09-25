package com.madgical.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By signUpMenu = By.xpath("//a[@class='nav-link'][contains(.,'Sign up')]");
    private By loginMenu = By.id("login2");
    private By signUpInputUserName = By.xpath("//input[@id='sign-username']");
    private By signUpInputPassword = By.id("sign-password");
    private By loginInputUserName = By.xpath("//input[@id='loginusername']");
    private By loginInputPassword = By.xpath("//input[@id='loginpassword']");
    private By signUpButton = By.xpath("//button[@type='button'][contains(.,'Sign up')]");
    private By loginButton = By.xpath("//button[contains(.,'Log in')]");

    private By userName = By.id("nameofuser");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnSignupMenu() {
        clickElement(signUpMenu);
        return this;
    }

    public HomePage enterSignUpDetails(String username, String password) {
        sendKeys(signUpInputUserName, username);
        sendKeys(signUpInputPassword, username);
        return this;
    }

    public HomePage enterLoginCredentials(String username, String password) {
        sendKeys(loginInputUserName, username);
        sendKeys(loginInputPassword, password);
        return this;
    }

    public boolean verifySignUpSuccessful() {
        return "Sign up successful.".equals(getAlertMessage());
    }

    public String getUserName() {
        return getText(this.userName);
    }

    public HomePage clickOnSignUp() {
        clickElement(signUpButton);
        return this;
    }

    public HomePage clickOnLogin() {
        clickElement(loginButton);
        return this;
    }

    public HomePage clickOnLoginMenu() {
        clickElement(loginMenu);
        return this;
    }

    public HomePage waitFor(long time) {
        try {
            Thread.sleep(time, 0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
