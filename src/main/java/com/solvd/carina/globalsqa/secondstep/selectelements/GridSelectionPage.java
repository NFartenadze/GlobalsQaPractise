package com.solvd.carina.globalsqa.secondstep.selectelements;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GridSelectionPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/selectable/display-grid.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//ol[@id='selectable']/li")
    private List<ExtendedWebElement> elements;

    @FindBy(xpath = "//ol[@id='selectable']")
    private ExtendedWebElement elementContainer;

    @FindBy(xpath = "//li[contains(@class, 'ui-selected')]")
    private List<ExtendedWebElement> selectedElements;
    private Actions actions;

    public GridSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }
    public int[] getSelectedElements(){
        int[] result = selectedElements.stream().mapToInt(element -> Integer.parseInt(element.getText())).toArray();
        return result;
    }


    public boolean isElementContainerPresent(){
        boolean result = elementContainer.isElementPresent();
        return result;
    }
    public void switchToFrame(){
        getDriver().switchTo().frame(frame.getElement());
    }
    public void switchToDefaultContent(){
        getDriver().switchTo().defaultContent();
    }
    public void selectElements(int[] e){
        for (int i = 0; i < e.length; i++) {
            new Actions(getDriver()).keyDown(elements.get(e[i]-1).getElement(),Keys.CONTROL).perform();
        }
    }
}
