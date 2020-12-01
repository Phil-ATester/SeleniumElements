package com.seleniumeasy.tests;

import com.seleniumeasy.pages.SimpleFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SimpleForm_001 extends BaseClass {

    @Test
    public void TC_SimpleFormTest_001(){
        SimpleFormPage formPage = new SimpleFormPage(driver);
        formPage.selectSimpleFormDemo();
        formPage.setMessage("This is my First Test");
        formPage.selectShowMessageButton();
        Assert.assertEquals(formPage.getMessage(), "This is my First Test", "Message incorrect");
    }

    @Test
    public void TC_SimpleFormTest_002(){
        SimpleFormPage formPage = new SimpleFormPage(driver);
        formPage.selectSimpleFormDemo();
        formPage.setAValue("10");
        formPage.setBValue("10");
        formPage.selectGetTotalButton();
        Assert.assertEquals(formPage.getSumValue(), "20", "Total incorrect");
    }
}
