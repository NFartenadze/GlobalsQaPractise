package com.solvd.carina.globalsqa.firststep.tabs;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ResizeAccordionPage extends AbstractPage implements IDriverPool {

    @FindBy(xpath= "//iframe[@data-src='../../demoSite/practice/accordion/fillspace.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-e']")
    private ExtendedWebElement handleRight;

    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-s']")
    private ExtendedWebElement handleDown;

    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    private ExtendedWebElement handleDownRight;


    public ResizeAccordionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }
    public boolean isHandleRightPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = handleRight.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public boolean isHandleDownPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = handleRight.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public boolean isHandleDownRightPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = handleDownRight.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void resizeRightSide(int px){
        getDriver().switchTo().frame(frame.getElement());
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(handleRight.getElement(),px,0).perform();
        getDriver().switchTo().defaultContent();
    }

    public void resizeDownSide(int px){
        getDriver().switchTo().frame(frame.getElement());
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(handleDown.getElement(),0,px).perform();
        getDriver().switchTo().defaultContent();
    }



    public void resizeDiagonally(int px){
        getDriver().switchTo().frame(frame.getElement());
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(handleDownRight.getElement(),px,px).perform();
        getDriver().switchTo().defaultContent();
    }
}
