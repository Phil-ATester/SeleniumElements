package com.seleniumeasy.tests;

import com.seleniumeasy.pages.JQuerySelectPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TC_JQuery_007 extends BaseClass {


    @Test
    public void JqueryDropDownTest_001() throws InterruptedException {
        JQuerySelectPage jQuerySelectPage = new JQuerySelectPage(driver);
        jQuerySelectPage.selectJQuerySelect();
        Thread.sleep(2000);  /// need a wait in test page
        jQuerySelectPage.selectCountry("Hong Kong");
        Assert.assertEquals(jQuerySelectPage.getCountry(), "Hong Kong");
        //Thread.sleep(4000);
    }


    @Test
    public void JqueryDropDownTest_002() throws InterruptedException {
        JQuerySelectPage jQuerySelectPage = new JQuerySelectPage(driver);
        jQuerySelectPage.selectJQuerySelect();

        ArrayList<String> states = new ArrayList<>(Arrays.asList("Arizona", "California", "Kansas"));
        for (String state: states){
            jQuerySelectPage.selectState(state);
        }

        //System.out.println("Arrays.Equals() results: " + jQuerySelectPage.getStates().equals(states));
        Boolean result = jQuerySelectPage.getStates().equals(states);
        //System.out.println("Result: " + result);
        Assert.assertTrue(result, "list Wrong");
        //Assert.assertTrue(jQuerySelectPage.getStates().equals(states), "List selected not correct");
       // Thread.sleep(4000);
    }


    @Test
    public void JqueryDropDownTest_003() throws InterruptedException {
        JQuerySelectPage jQuerySelectPage = new JQuerySelectPage(driver);
        jQuerySelectPage.selectJQuerySelect();
        Thread.sleep(1000);
        //jQuerySelectPage.selectUSTerritory("Virgin Islands");
        jQuerySelectPage.selectUSTerritory("Guam");
        //Thread.sleep(3000);
    }

    @Test
    public void JQueryDropDownTest_004() throws InterruptedException {
        JQuerySelectPage jQuerySelectPage = new JQuerySelectPage(driver);
        jQuerySelectPage.selectJQuerySelect();
        jQuerySelectPage.selectLanguage("PHP");

       // Thread.sleep(3000);
    }

}
