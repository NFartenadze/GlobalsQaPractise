package com.solvd.carina.globalsqa.firststep.progressbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DownloadManagerPage extends AbstractPage {
    @FindBy(xpath = "//iframe[@data-src='../../demoSite/practice/progressbar/download.html']")
    private ExtendedWebElement frame;

    @FindBy(xpath = "//button[@id='downloadButton']")
    private ExtendedWebElement downloadButton;

    @FindBy(xpath = "//div[@class='progress-label']")
    private ExtendedWebElement progressLabel;

    @FindBy(css = ".ui-dialog")
    private ExtendedWebElement fileDownloadPane;
    public DownloadManagerPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/progress-bar/#Download%20Manager");
    }

    @Override
    public boolean isPageOpened(){
        return frame.isElementPresent();
    }
    public boolean isDownloadButtonPresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = downloadButton.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }

    public boolean isFileDownloadPanePresent(){
        getDriver().switchTo().frame(frame.getElement());
        boolean result = fileDownloadPane.isElementPresent();
        getDriver().switchTo().defaultContent();
        return result;
    }
    public void clickDownloadBtn(){
        getDriver().switchTo().frame(frame.getElement());
        downloadButton.click();
        getDriver().switchTo().defaultContent();
    }

    public String getProgressLabelText(){
        getDriver().switchTo().frame(frame.getElement());
        String result = progressLabel.getText();
        getDriver().switchTo().defaultContent();
        return result;
    }
}
