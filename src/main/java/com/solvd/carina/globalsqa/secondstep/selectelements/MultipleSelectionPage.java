package com.solvd.carina.globalsqa.secondstep.selectelements;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.model.Frame;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MultipleSelectionPage extends AbstractPage {

    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/selectable/default.html']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//ol[@id='selectable']/li")
    private List<ExtendedWebElement> elements;

    @FindBy(xpath = "//ol[@id='selectable']")
    private ExtendedWebElement elementContainer;

    @FindBy(xpath = "//li[contains(@class, 'ui-selected')]")
    private List<ExtendedWebElement> selectedElements;
    public MultipleSelectionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/select-elements/#Multiple%20Selection");
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public List<ExtendedWebElement> getSelectedElements(){
        return selectedElements;
    }
    public void switchToFrame(){
        getDriver().switchTo().frame(frame.getElement());
    }
    public void switchToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }

    public boolean isElementContainerPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = elementContainer.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public void selectElements(int from, int to){
        getDriver().switchTo().frame(frame.getElement());
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(elements.get(from-1).getElement())
                .moveToElement(elements.get(to-1).getElement())
                .release().perform();
    }



}
