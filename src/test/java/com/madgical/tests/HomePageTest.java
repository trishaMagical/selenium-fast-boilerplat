package com.madgical.tests;


import com.madgical.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void signUpTest() {
        HomePage startPage = new HomePage(driver);
        boolean result = startPage.clickOnSignupMenu()
                .enterSignUpDetails("58562AFB-AAD7-4211-AEB9-0A18A629FE56"+System.currentTimeMillis(), "mypassword")
                .clickOnSignUp()
                .verifySignUpSuccessful();
        Assert.assertTrue(result, "Sign up not successful");
    }

    @Test
    public void loginTest() {
        HomePage startPage = new HomePage(driver);
        String result = startPage.clickOnLoginMenu()
                .enterLoginCredentials("test20230923710", "random")
                .clickOnLogin()
                .waitFor(2000)
                .getUserName();
        Assert.assertEquals(result,"Welcome test20230923710", "Login is not successful");
    }
}
