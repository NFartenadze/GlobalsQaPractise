package com.solvd.carina.globalsqa.firststep.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FormBasedPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/tooltip/forms.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@role='tooltip']")
    private ExtendedWebElement tooltip;

    @FindBy(css = "//button[contains(text(),'Show help')]")
    private ExtendedWebElement showHelpTooltipsBtn;

    public FormBasedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public boolean isTooltipPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = tooltip.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public boolean isShowHelpBtnPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = showHelpTooltipsBtn.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public void clickShowHelpBtn(){
        getDriver().switchTo().frame(frame.getElement());
        showHelpTooltipsBtn.click();
        getDriver().switchTo().defaultContent();
    }

}
