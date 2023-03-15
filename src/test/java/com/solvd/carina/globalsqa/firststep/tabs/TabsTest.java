package com.solvd.carina.globalsqa.firststep.tabs;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.globalsqa.TabsNavigation;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabsTest implements IAbstractTest {

    @Test
    public void selectAccordions(){
        SimpleAccordionPage simpleAccordionPage = new SimpleAccordionPage(getDriver());
        simpleAccordionPage.open();
        Assert.assertTrue(simpleAccordionPage.isPageOpened(),"Simple Accordion Page isn't opened");
        Assert.assertTrue(simpleAccordionPage.isSectionPresent(1),"Section 1 isn't present");
//        Assert.assertNotEquals(simpleAccordionPage.getSectionText(1),"","Accordion text should not be empty");

        Assert.assertTrue(simpleAccordionPage.isSectionPresent(2),"Section 2 isn't present");
        simpleAccordionPage.selectSection(2);
//        Assert.assertNotEquals(simpleAccordionPage.getSectionText(2),"","Accordion text should not be empty");

        Assert.assertTrue(simpleAccordionPage.isSectionPresent(3), "Section 3 isn't present");
        simpleAccordionPage.selectSection(3);
//        Assert.assertNotEquals(simpleAccordionPage.getSectionText(3),"","Accordion text should not be empty");

        Assert.assertTrue(simpleAccordionPage.isSectionPresent(4),"Section 4 isn't present");
        simpleAccordionPage.selectSection(4);
//        Assert.assertNotEquals(simpleAccordionPage.getSectionText(4),"","Accordion text should not be empty");
    }

    @Test
    public void resizeAccordions(){
        SimpleAccordionPage simpleAccordionPage = new SimpleAccordionPage(getDriver());
        simpleAccordionPage.open();
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(1);
        ResizeAccordionPage resizeAccordionPage = new ResizeAccordionPage(getDriver());
        Assert.assertTrue(resizeAccordionPage.isPageOpened(),"Resize Accordion Page isn't opened");
        Assert.assertTrue(resizeAccordionPage.isHandleRightPresent(),"Right side handle isn't present");
        resizeAccordionPage.resizeRightSide(200);
        Assert.assertTrue(resizeAccordionPage.isHandleDownPresent(),"Down side handle isn't present");
        resizeAccordionPage.resizeDownSide(100);
        Assert.assertTrue(resizeAccordionPage.isHandleDownRightPresent(),"Down Right handle isn't present");
        resizeAccordionPage.resizeDiagonally(50);
    }

    @Test
    public void toggleIcons(){
        SimpleAccordionPage simpleAccordionPage = new SimpleAccordionPage(getDriver());
        simpleAccordionPage.open();
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(2);
        ToggleIconsPage toggleIconsPage = new ToggleIconsPage(getDriver());
        Assert.assertTrue(toggleIconsPage.isPageOpened(),"Toggle Icons Page isn't opened");
        Assert.assertTrue(toggleIconsPage.isIconPresent(1),"Icon before Section title isn't present");
        Assert.assertTrue(toggleIconsPage.isToggleIconsBtnPresent(), "Toggle icons button isn't present");
        toggleIconsPage.toggleIcons();
        Assert.assertThrows(NoSuchElementException.class,()->{
            toggleIconsPage.isIconPresent(1);
        });
    }

}