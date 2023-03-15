package com.solvd.carina.globalsqa.firststep.progressbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RandomProgressBarPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/progressbar/indeterminate.html']")
    private ExtendedWebElement frame;
    @FindBy(xpath = "//button[@id='numButton']")
    private ExtendedWebElement determinateBtn;
    @FindBy(xpath = "//button[@id='falseButton']")
    private ExtendedWebElement indeterminateBtn;
    @FindBy(xpath = "//button[@id='colorButton']")
    private ExtendedWebElement randomColorBtn;
    @FindBy(xpath ="//div[@id='progressbar']")
    private ExtendedWebElement progressBar;


    public RandomProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }

    public String getProgressBarValue(){
        getDriver().switchTo().frame(frame.getElement());
        String result = progressBar.getAttribute("aria-valuenow");
        getDriver().switchTo().defaultContent();
        return result;
    }
    public boolean isDeterminateBtnPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = determinateBtn.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public boolean isIndeterminateBtnPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = indeterminateBtn.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void clickIndeterminateBtn(){
        getDriver().switchTo().frame(frame.getElement());
        indeterminateBtn.click();
        getDriver().switchTo().defaultContent();
    }
    public boolean isRandomColorBtnPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = randomColorBtn.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void clickRandomColorBtn(){
        getDriver().switchTo().frame(frame.getElement());
        randomColorBtn.click();
        getDriver().switchTo().defaultContent();
    }

    public void clickDeterminateBtn(){
        getDriver().switchTo().frame(frame.getElement());
        determinateBtn.click();
        getDriver().switchTo().defaultContent();
    }



}
