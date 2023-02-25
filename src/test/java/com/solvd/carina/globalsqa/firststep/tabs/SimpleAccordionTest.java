package com.solvd.carina.globalsqa.firststep.tabs;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class SimpleAccordionTest implements IAbstractTest {

    @Test
    public void selectAccordions(){
        SimpleAccordionPage accordion = new SimpleAccordionPage(getDriver());
        accordion.open();
        Assert.assertTrue(accordion.isSectionPresent(1));
        System.out.println(accordion.getSectionText(1));
//        Assert.assertNotEquals(accordion.getSectionText(1),"","Accordion text should not be empty");

        Assert.assertTrue(accordion.isSectionPresent(2));
        accordion.selectSection(2);
//        Assert.assertNotEquals(accordion.getSectionText(2),"","Accordion text should not be empty");

        Assert.assertTrue(accordion.isSectionPresent(3));
        accordion.selectSection(3);
//        Assert.assertNotEquals(accordion.getSectionText(3),"","Accordion text should not be empty");
    }
}