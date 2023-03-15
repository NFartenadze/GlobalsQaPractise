package com.solvd.carina.globalsqa.firststep.progressbar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.globalsqa.TabsNavigation;
import org.codehaus.groovy.ast.expr.GStringExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgressBarTest implements IAbstractTest {


    @Test
    public void fileGetsDownloaded(){
        DownloadManagerPage downloadManager = new DownloadManagerPage(getDriver());
        downloadManager.open();
        Assert.assertTrue(downloadManager.isPageOpened(),"Download manager page isn't opened");
        Assert.assertTrue(downloadManager.isDownloadButtonPresent(),"download button isn't present");
        downloadManager.clickDownloadBtn();
        Assert.assertTrue(downloadManager.isFileDownloadPanePresent(),"file download dialogue pane isn't present");
        Assert.assertEquals(downloadManager.getProgressLabelText(),"Complete!");
    }

    @Test
    public void randomProgressTest(){
        DownloadManagerPage downloadManager = new DownloadManagerPage(getDriver());
        downloadManager.open();
        Assert.assertTrue(downloadManager.isPageOpened(),"Download manager page isn't opened");
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(1);

        RandomProgressBarPage randomProgressBar = new RandomProgressBarPage(getDriver());
        Assert.assertTrue(randomProgressBar.isPageOpened(),"random progress bar page isn't opened");
        Assert.assertTrue(randomProgressBar.isDeterminateBtnPresent(),"Determinate button isn't present");
        randomProgressBar.clickDeterminateBtn();
        Assert.assertNotEquals(randomProgressBar.getProgressBarValue(),"0");

        Assert.assertTrue(randomProgressBar.isIndeterminateBtnPresent(),"indeterminate button isn't present");
        randomProgressBar.clickIndeterminateBtn();

        Assert.assertTrue(randomProgressBar.isIndeterminateBtnPresent(),"indeterminate button isn't present");
        randomProgressBar.clickIndeterminateBtn();
        Assert.assertEquals(randomProgressBar.getProgressBarValue(),null);
    }





}