package com.solvd.carina.globalsqa;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TabsNavigation extends AbstractUIObject {
    @FindBy(xpath = "//ul[@class='resp-tabs-list ']/li")
    private List<ExtendedWebElement> tabs;

    public TabsNavigation(WebDriver driver) {
        super(driver);
        setPageURL("https://www.globalsqa.com/demo-site/accordion-and-tabs/#Simple%20Accordion");
    }

    public void navigateToTab(int index){
        tabs.get(index).scrollTo();
        tabs.get(index).click();
    }


}
