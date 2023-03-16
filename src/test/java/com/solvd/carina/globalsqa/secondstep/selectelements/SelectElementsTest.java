package com.solvd.carina.globalsqa.secondstep.selectelements;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.globalsqa.TabsNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectElementsTest implements IAbstractTest {

    @Test
    public void selectElementsByDrawingBoxWithCursor(){
        MultipleSelectionPage multipleSelectionPage = new MultipleSelectionPage(getDriver());
        multipleSelectionPage.open();
        Assert.assertTrue(multipleSelectionPage.isPageOpened(),"Multiple selection page isn't opened");
        multipleSelectionPage.switchToFrame();
        Assert.assertTrue(multipleSelectionPage.isElementContainerPresent(),"elements container isn't present");
        multipleSelectionPage.selectElements(2,5);
        Assert.assertEquals(multipleSelectionPage.getSelectedElements().size(),4,"Desired selection doesn't equal to actual selection");
        multipleSelectionPage.switchToDefaultContent();
    }

    @Test
    public void makeMultipleNonAdjacentSelections(){
        MultipleSelectionPage multipleSelectionPage = new MultipleSelectionPage(getDriver());
        multipleSelectionPage.open();
        Assert.assertTrue(multipleSelectionPage.isPageOpened(),"multiple selection page isn't opened");
        TabsNavigation tabsNavigation = new TabsNavigation(getDriver());
        tabsNavigation.navigateToTab(1);
        GridSelectionPage gridSelection = new GridSelectionPage(getDriver());
        Assert.assertTrue(gridSelection.isPageOpened(),"grid selection page isn't opened");
        gridSelection.switchToFrame();
        Assert.assertTrue(gridSelection.isElementContainerPresent(),"Elements container isn't present");
        gridSelection.selectElements(new int[]{1,4,5});
        Assert.assertEquals(gridSelection.getSelectedElements(),new int[]{1,4,5});
        gridSelection.switchToDefaultContent();
    }
}
