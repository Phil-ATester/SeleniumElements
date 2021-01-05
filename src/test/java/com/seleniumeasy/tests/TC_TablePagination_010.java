package com.seleniumeasy.tests;

import com.seleniumeasy.pages.TablePagination;
import org.testng.annotations.Test;

public class TC_TablePagination_010 extends BaseClass{

    @Test
    public void TestActualRecords() {//throws InterruptedException {
        TablePagination tablePagination = new TablePagination(driver);
        tablePagination.selectTablePagination();
        //tablePagination.paginationWithForLoop();
        tablePagination.paginationDynamic();
    }
}
