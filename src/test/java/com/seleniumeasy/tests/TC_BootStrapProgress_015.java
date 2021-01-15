package com.seleniumeasy.tests;

import com.seleniumeasy.pages.BootstrapProgressBar;
import org.testng.annotations.Test;

public class TC_BootStrapProgress_015 extends BaseClass{

    @Test
    public void TestProgress() throws InterruptedException {
        BootstrapProgressBar bootstrapProgressBar = new BootstrapProgressBar(driver);
        bootstrapProgressBar.selectBootstapProgessLink();
        Thread.sleep(2000);
        bootstrapProgressBar.selectDownloadButton();
        bootstrapProgressBar.isDownloadSuccessfull();
    }
}
