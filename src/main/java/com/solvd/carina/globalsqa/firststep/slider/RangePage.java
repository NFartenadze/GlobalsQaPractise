package com.solvd.carina.globalsqa.firststep.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RangePage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/slider/range.html']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@id='slider-range']")
    private ExtendedWebElement slider;
    @FindBy(xpath = "//div[@id='slider-range']/span[1]")
    private ExtendedWebElement leftHandle;

    @FindBy(xpath = "//div[@id='slider-range']/span[2]")
    private ExtendedWebElement rightHandle;
    public RangePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/sliders/#Range");
    }


    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public void setRange(int from, int to){
        Actions action = new Actions(getDriver());
        getDriver().switchTo().frame(frame.getElement());
        action.dragAndDropBy(leftHandle.getElement(), from,0).perform();
        action.dragAndDropBy(rightHandle.getElement(),to,0).perform();
        getDriver().switchTo().defaultContent();
    }

    public boolean isLeftHandlePresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result =  leftHandle.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public boolean isRightHandlePresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result =  rightHandle.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

}
