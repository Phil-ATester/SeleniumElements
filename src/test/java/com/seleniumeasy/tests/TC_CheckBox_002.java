package com.seleniumeasy.tests;

import com.seleniumeasy.pages.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_CheckBox_002 extends BaseClass{


    @Test
    public void TestCheckBox_001() throws InterruptedException {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.selectCheckBoxDemo();
        Thread.sleep(2000);  //
        checkBoxPage.selectCheckBox();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //Assert.assertEquals(checkBoxPage.getMessage(), "Success - Check book is Checked", "No Message displayed for single checkbox demo");
        Assert.assertTrue(checkBoxPage.isMessagePresent());
    }

    @Test
    public void TestCheckBox_002() throws InterruptedException {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.selectCheckBoxDemo();

        //driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        Thread.sleep(2000);
        checkBoxPage.selectCheckButton();
        Assert.assertEquals(checkBoxPage.getButtonValue(), "Uncheck All", "Incorrect Button : Uncheck All");

        checkBoxPage.selectCheckboxOption("1");
        checkBoxPage.selectCheckboxOption("2");
        Assert.assertEquals(checkBoxPage.getButtonValue(), "Check All", "Incorrect Button : Check All");

    }
}
