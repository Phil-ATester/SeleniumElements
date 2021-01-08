package com.seleniumeasy.tests;

import com.seleniumeasy.pages.TableDataSearchPage;
import org.testng.annotations.Test;

public class TC_TableDataSearch_011 extends BaseClass{

    /*
    @Test
    public void TestSearch() throws InterruptedException {
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);
        tableDataSearchPage.selectTableDataSearch();
        //tableDataSearchPage.confirmSearch("In progress");
        tableDataSearchPage.confirmSearch("failed qa");
    }*/

    @Test
    public void TestFilerUser() throws InterruptedException {
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);
        tableDataSearchPage.selectTableDataSearch();
        //tableDataSearchPage.filterUser("mikesali", "firstname");
        tableDataSearchPage.filterUser("Dimarison", "lastname");
    }
}
