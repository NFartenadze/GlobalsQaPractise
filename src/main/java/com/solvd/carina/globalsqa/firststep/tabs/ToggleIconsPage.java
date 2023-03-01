package com.solvd.carina.globalsqa.firststep.tabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class ToggleIconsPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/accordion/custom-icons.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//div[@id = 'accordion']//h3[contains(text(),'Section %d')]")
    private ExtendedWebElement section;
    @FindBy(xpath = "//button[@id='toggle']")
    private ExtendedWebElement toggleIconsBtn;
    public ToggleIconsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public boolean isSectionPresent(int sectionIndex){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = section.format(sectionIndex).isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void selectSection(int sectionIndex){
        getDriver().switchTo().frame(frame.getElement());
        section.format(sectionIndex).click();
        getDriver().switchTo().defaultContent();
    }
    public boolean isIconPresent(int sectionIndex){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = section.format(sectionIndex).findExtendedWebElement(By.xpath("//span")).isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public void toggleIcons(){
        getDriver().switchTo().frame(frame.getElement());
        toggleIconsBtn.click();
        getDriver().switchTo().defaultContent();
    }

    public boolean isToggleIconsBtnPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = toggleIconsBtn.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
}
