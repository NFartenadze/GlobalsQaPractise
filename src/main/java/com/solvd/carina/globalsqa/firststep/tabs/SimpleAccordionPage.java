package com.solvd.carina.globalsqa.firststep.tabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SimpleAccordionPage extends AbstractPage {

    @FindBy(css = ".demo-frame.lazyloaded")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//div[@id = 'accordion']//div[%d]/p")
    private ExtendedWebElement sectionText;
    @FindBy(xpath = "//div[@id = 'accordion']//h3[contains(text(),'Section %d')]")
    private ExtendedWebElement section;

    public SimpleAccordionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/accordion-and-tabs/#Simple%20Accordion");
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
    public String getSectionText(int sectionIndex){
        getDriver().switchTo().frame(frame.getElement());
        String result = sectionText.format(sectionIndex).getText();
        getDriver().switchTo().defaultContent();
        return result;
    }
}
