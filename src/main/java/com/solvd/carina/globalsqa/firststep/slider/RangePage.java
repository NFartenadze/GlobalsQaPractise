package com.solvd.carina.globalsqa.firststep.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RangePage extends AbstractPage {
    @FindBy(css = ".demo-frame.lazyloaded")
    private ExtendedWebElement frame;
    public RangePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.globalsqa.com/demo-site/sliders/#Range");
    }
}
