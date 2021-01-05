package com.seleniumeasy.tests;

import com.seleniumeasy.pages.BootstrapDatePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.testng.Assert.assertEquals;

public class TC_DatePicker_008 extends BaseClass{

    private BootstrapDatePage datePage;

    @BeforeMethod
    public void selectPage() {
        datePage = new BootstrapDatePage(driver);
        datePage.selectBootstrapDatePicker();
    }

    /*
    @Test
    public void TestDatePicker_001() throws InterruptedException {
        //BootstrapDatePage datePage = new BootstrapDatePage(driver);
        //datePage.selectBootstrapDatePicker();
        datePage.selectDate("7", "12", "2020");
        Thread.sleep(3000);
    }*/

    @Test
    public void TestDatePicker_002() throws InterruptedException {
        LocalDate dateToSelect = LocalDate.of(2020, Month.OCTOBER, 20);
        datePage.chooseDate(dateToSelect);
        //assertEquals(dateToSelect, selectedDate);
        Thread.sleep(3000);
    }
}
