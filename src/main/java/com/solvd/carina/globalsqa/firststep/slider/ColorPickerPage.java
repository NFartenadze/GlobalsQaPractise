package com.solvd.carina.globalsqa.firststep.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ColorPickerPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/slider/colorpicker.html']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@id='%s']/span")
    private ExtendedWebElement color;
    public ColorPickerPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/sliders/#Color%20Picker");
    }
    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public boolean isColorHandlePresent(String colorName){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = color.format(colorName).isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public void moveColorHandle(String colorName, String direction, int amountInPx){
        getDriver().switchTo().frame(frame.getElement());
        Actions action = new Actions(getDriver());
        if(direction.equals("right")){
            action.dragAndDropBy(color.format(colorName).getElement(),amountInPx,0).perform();
        }
        if(direction.equals("left")){
            action.dragAndDropBy(color.format(colorName).getElement(),amountInPx * -1,0).perform();
        }
        getDriver().switchTo().defaultContent();
    }
}
