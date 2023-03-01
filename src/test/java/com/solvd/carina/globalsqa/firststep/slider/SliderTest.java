package com.solvd.carina.globalsqa.firststep.slider;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.Range;

import static org.testng.Assert.*;

public class SliderTest implements IAbstractTest {

    @Test
    public void colorPicker(){
        ColorPickerPage colorPickerPage = new ColorPickerPage(getDriver());
        colorPickerPage.open();
        Assert.assertTrue(colorPickerPage.isPageOpened(),"Color picker page isn't opened");
    }

    @Test
    public void range(){
        RangePage rangePage = new RangePage(getDriver());
        rangePage.open();
        Assert.assertTrue(rangePage.isPageOpened(),"Range page isn't opened");
    }

    @Test
    public void steps(){
        StepsPage stepsPage = new StepsPage(getDriver());
        stepsPage.open();
        Assert.assertTrue(stepsPage.isPageOpened(),"Steps page isn't opened");
    }
}