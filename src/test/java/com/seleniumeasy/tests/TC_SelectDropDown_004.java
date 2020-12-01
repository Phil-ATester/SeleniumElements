package com.seleniumeasy.tests;

import com.seleniumeasy.pages.SelectDropDownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SelectDropDown_004 extends BaseClass{

    @Test
    public void selectTest_001() throws InterruptedException {
        SelectDropDownPage selectDropDownPage = new SelectDropDownPage(driver);
        selectDropDownPage.selectDropDownDemo();
        selectDropDownPage.selectDay("Tuesday");
        Assert.assertTrue(selectDropDownPage.getDaySelected().contains("Tuesday"));
    }

    @Test
    public void MultiSelectTest_002() throws InterruptedException {
        SelectDropDownPage selectDropDownPage = new SelectDropDownPage(driver);
        selectDropDownPage.selectDropDownDemo();

        selectDropDownPage.selectCountry("California");
        selectDropDownPage.selectCountry("New York");

        //To-do Assert that options are selected/
    }

}
