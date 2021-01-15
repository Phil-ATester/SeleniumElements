package com.seleniumeasy.tests;

import com.seleniumeasy.pages.BootstrapModal;
import org.testng.annotations.Test;

public class TC_BootStrapModals_018 extends BaseClass{

    @Test
    public void TestAlert_001() { //throws InterruptedException {
        BootstrapModal bootstrapModal = new BootstrapModal(driver);
        bootstrapModal.selectBootstrapModal();
        bootstrapModal.selectLaunchModal();
       //Thread.sleep(2000);
    }

    @Test
    public void TestMultiAlert_002() { //throws InterruptedException {
        BootstrapModal bootstrapModal = new BootstrapModal(driver);
        bootstrapModal.selectBootstrapModal();
        bootstrapModal.selectMultipleModal();
        //Thread.sleep(4000);
    }
}
