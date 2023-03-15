package com.solvd.carina.globalsqa.secondstep.selectelements;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.globalsqa.secondstep.dropdown.SelectCountryPage;
import org.apache.ibatis.annotations.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectorTest implements IAbstractTest {
    @Test
    public void selectDifferentCountries(){
        SelectCountryPage selectCountryPage = new SelectCountryPage(getDriver());
        selectCountryPage.open();
        Assert.assertTrue(selectCountryPage.isPageOpened(),"select country page isn't opened");
        Assert.assertTrue(selectCountryPage.isCountrySelectorPresent(),"country selector isn't present");
        selectCountryPage.selectCountry("Australia");
        Assert.assertEquals(selectCountryPage.getSelectedCountryName(),"Australia");
    }

}