package com.solvd.carina.globalsqa.firststep.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VideoBasedPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/tooltip/video-player.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@role='tooltip']")
    private ExtendedWebElement tooltip;

    @FindBy(css = ".ui-button")
    private List<ExtendedWebElement> buttons;

    public VideoBasedPage(WebDriver driver) {
        super(driver);
        //setPageAbsoluteURL("https://www.globalsqa.com/demo-site/tooltip/#Video%20Based");
        //links don't work directly
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public boolean isButtonPresent(int index){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = buttons.get(index).isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void hoverButton(int index){
        getDriver().switchTo().frame(frame.getElement());
        buttons.get(index).hover();
        getDriver().switchTo().defaultContent();
    }
    public boolean isTooltipPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = tooltip.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }



}
