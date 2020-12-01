package com.seleniumeasy.tests;

import com.seleniumeasy.pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_RadioButton_003 extends BaseClass{

    @Test
    public void radioButtonTest_001() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.selectRadioButtonDemo();

        radioButtonPage.selectMaleRB();
        radioButtonPage.selectCheckValueButton();
        Assert.assertTrue(radioButtonPage.getCheckValueMessage().contains("Male"));

        radioButtonPage.selectFemaleRB();
        radioButtonPage.selectCheckValueButton();
        Assert.assertEquals(radioButtonPage.getCheckValueMessage(), "Radio button 'Female' is checked", "Female message not displayed");

    }

    @Test
    public void groupRadioButtonTest_002() throws InterruptedException {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.selectRadioButtonDemo();

        radioButtonPage.selectMaleGroupRB();
        radioButtonPage.selectLowRB();
        radioButtonPage.selectGetValueButton();

        System.out.println("result: " + radioButtonPage.getValueMessage());
        String gender = "Male";
        String age = "0 - 5";
        Assert.assertTrue(radioButtonPage.getValueMessage().contains(gender) & radioButtonPage.getValueMessage().contains(age));
    }


}
