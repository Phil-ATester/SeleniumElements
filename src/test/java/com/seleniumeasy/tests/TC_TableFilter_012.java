package com.seleniumeasy.tests;

import com.seleniumeasy.pages.TableFilterPage;
import org.testng.annotations.Test;

public class TC_TableFilter_012 extends BaseClass{

    @Test
    public void TestFilter() throws InterruptedException {
        TableFilterPage tableFilterPage = new TableFilterPage(driver);
        tableFilterPage.selectTableFilter();
        tableFilterPage.filterRecord("All");
    }
}
