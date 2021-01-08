package com.seleniumeasy.tests;

import com.seleniumeasy.pages.TableDataSearchPage;
import com.seleniumeasy.pages.TableSortPage;
import org.testng.annotations.Test;

public class TC_TableSearch_013 extends BaseClass{

    @Test
    public void testSearch() throws InterruptedException {
        TableSortPage tableSortPage = new TableSortPage(driver);
        tableSortPage.selectTableFilter();
        //tableSortPage.searchRecords("London");
        tableSortPage.paginationDynamic();
    }
}
