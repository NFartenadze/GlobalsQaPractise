package com.solvd.carina.solvd.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.solvd.com/");
    }


}
