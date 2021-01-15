package com.seleniumeasy.tests;

import com.seleniumeasy.pages.ProgressBar;
import org.testng.annotations.Test;

public class TC_ProgressBarModal_20 extends BaseClass{

    @Test
    public void testProgressBar() throws InterruptedException {
        ProgressBar progressBar = new ProgressBar(driver);
        progressBar.selectProgressBarModal();
        progressBar.selectSimpleDialog();
        Thread.sleep(4000);
    }

    @Test
    public void testProgressBar2() throws InterruptedException {
        ProgressBar progressBar = new ProgressBar(driver);
        progressBar.selectProgressBarModal();
        progressBar.selectCustomDialog();
        Thread.sleep(4000);
    }

    @Test
    public void testProgressBar3() throws InterruptedException {
        ProgressBar progressBar = new ProgressBar(driver);
        progressBar.selectProgressBarModal();
        progressBar.selectCustomSettingDialog();
        Thread.sleep(4000);
    }
}
