package com.solvd.carina.globalsqa.secondstep.selectelements;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectElementsTest implements IAbstractTest {

    @Test
    public void selectElements(){
        MultipleSelectionPage multipleSelectionPage = new MultipleSelectionPage(getDriver());
        multipleSelectionPage.open();
        Assert.assertTrue(multipleSelectionPage.isPageOpened(),"Multiple selection page isn't opened");
        Assert.assertTrue(multipleSelectionPage.isElementContainerPresent(),"elements container isn't present");
        multipleSelectionPage.selectElements(2,5);
        Assert.assertEquals(multipleSelectionPage.getSelectedElements().size(),4,"Desired selection doesn't equal to actual selection");
    }
}
