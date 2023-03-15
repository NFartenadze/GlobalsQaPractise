package com.solvd.carina.globalsqa.secondstep.dropdown;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.ibatis.annotations.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SelectCountryPage extends AbstractPage {
    @FindBy(css = ".single_tab_div p select")
    private ExtendedWebElement countrySelector;
    public SelectCountryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
    }

    public boolean isCountrySelectorPresent(){
        return countrySelector.isElementPresent();
    }
    public void selectCountry(String countryName){
        countrySelector.select(countryName);
    }

    public String getSelectedCountryName(){
        return countrySelector.getSelectedValue();
    }

}
