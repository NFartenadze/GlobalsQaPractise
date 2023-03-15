package com.solvd.carina.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SauceDemoTest implements IAbstractTest {

    @Test
    public void loginUser(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.addCookie(new Cookie("session-username", "standard_user", ".saucedemo.com", "/", null));
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home Page isn't opened");
    }
}