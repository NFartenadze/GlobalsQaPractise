package com.solvd.carina.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private ExtendedWebElement usernameField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@data-test-id='login-button']")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.saucedemo.com/");
    }

    public void typeUserName(String userName){
        usernameField.type(userName);
    }
    public void typePassword(String password){
        passwordField.type(password);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }

}
