package com.solvd.carina.globalsqa.firststep.tooltip;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.globalsqa.TabsNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TooltipTest implements IAbstractTest {

    @Test
    public void checkIfImageTooltipExists(){
        ImageBasedPage imageBasedPage = new ImageBasedPage(getDriver());
        imageBasedPage.open();
        Assert.assertTrue(imageBasedPage.isPageOpened(),"Image Based Page isn't opened");
        Assert.assertTrue(imageBasedPage.isImagePresent(1),"Image isn't present");
        imageBasedPage.hoverImage(1);
        Assert.assertTrue(imageBasedPage.isTooltipPresent(),"tooltip isn't present");
    }

    @Test
    public void checkIfVideoTooltipExists(){
        ImageBasedPage imageBasedPage = new ImageBasedPage(getDriver());
        imageBasedPage.open();
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(1);
        VideoBasedPage videoBasedPage = new VideoBasedPage(getDriver());
        Assert.assertTrue(videoBasedPage.isPageOpened(),"page isn't present");
        Assert.assertTrue(videoBasedPage.isButtonPresent(1),"button isn't present");
        videoBasedPage.hoverButton(1);
        Assert.assertTrue(videoBasedPage.isTooltipPresent(),"Tool tip isn't present");
    }

    @Test
    public void checkIfFormTooltipExists(){
        ImageBasedPage imageBasedPage = new ImageBasedPage(getDriver());
        imageBasedPage.open();
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(2);
        FormBasedPage formBasedPage = new FormBasedPage(getDriver());
        Assert.assertTrue(formBasedPage.isPageOpened(),"page isn't opened");
        Assert.assertTrue(formBasedPage.isShowHelpBtnPresent(),"Show help button isn't present");
        formBasedPage.clickShowHelpBtn();
        Assert.assertTrue(formBasedPage.isTooltipPresent(),"Tool tip isn't present");
    }

}