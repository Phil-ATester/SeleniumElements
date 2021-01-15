package com.seleniumeasy.tests;

import com.seleniumeasy.pages.JQueryProgressBar;
import org.testng.annotations.Test;

public class TC_JQueryProgressBar_014 extends BaseClass{

    @Test
    public void testProgressBar() throws InterruptedException {
        JQueryProgressBar jQueryProgressBar = new JQueryProgressBar(driver);
        jQueryProgressBar.selectJQueryDownload();
        Thread.sleep(1000);
        jQueryProgressBar.selectDownload();
        jQueryProgressBar.showProgress();
        //jQueryProgressBar.selectCloseButton();
        Thread.sleep(6000);
    }
}
