package com.solvd.carina.globalsqa.firststep.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class StepsPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/slider/steps.html']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@id='slider']/span")
    private ExtendedWebElement handle;
    public StepsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/sliders/#Steps");
    }
    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public void increment(int times){
        Actions action = new Actions(getDriver());
        getDriver().switchTo().frame(frame.getElement());
        action.dragAndDropBy(handle.getElement(),times*69,0).perform();
        getDriver().switchTo().defaultContent();
    }

    public boolean isHandlePresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = handle.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
}
