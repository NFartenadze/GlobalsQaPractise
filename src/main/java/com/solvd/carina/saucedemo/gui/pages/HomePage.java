package com.solvd.carina.saucedemo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "inventory_container")
    private ExtendedWebElement inventoryContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.saucedemo.com/inventory.html");
    }

    @Override
    public boolean isPageOpened(){
        return inventoryContainer.isElementPresent();
    }
}
