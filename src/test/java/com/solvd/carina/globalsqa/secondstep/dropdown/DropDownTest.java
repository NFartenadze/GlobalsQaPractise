package com.solvd.carina.globalsqa.secondstep.dropdown;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import groovy.lang.Tuple;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest implements IAbstractTest {
    @Test
    public void selectDifferentCountries(){
        SelectCountryPage selectCountryPage = new SelectCountryPage(getDriver());
        selectCountryPage.open();
        Assert.assertTrue(selectCountryPage.isPageOpened(),"select country page isn't opened");
        Assert.assertTrue(selectCountryPage.isCountrySelectorPresent(),"country selector isn't present");
        selectCountryPage.selectCountry("Australia");
        Assert.assertEquals(selectCountryPage.getSelectedCountryName(),"Australia");
        Tuple tuple = new Tuple(1,true,"hello");
    }

}