package com.solvd.carina.globalsqa.firststep.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ImageBasedPage extends AbstractPage {

    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/tooltip/custom-content.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@role='tooltip']")
    private ExtendedWebElement tooltip;

    @FindBy(xpath = "//div[@class='ui-widget photo']//img")
    private List<ExtendedWebElement> image;
    public ImageBasedPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/tooltip/");
    }

    public boolean isImagePresent(int index){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = image.get(index).isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void hoverImage(int index){
        getDriver().switchTo().frame(frame.getElement());
        image.get(index).scrollTo();
        image.get(index).hover();
        getDriver().switchTo().defaultContent();
    }
    public boolean isTooltipPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = tooltip.isElementPresent();
        return tooltip.isElementPresent();
    }
}
