package com.seleniumeasy.tests;

import com.seleniumeasy.pages.BootStrapAlert;
import org.testng.annotations.Test;

public class TC_BootStrapAlerts_017 extends BaseClass{

    @Test
    public void AlertTest001() throws InterruptedException {
        BootStrapAlert bootStrapAlert = new BootStrapAlert(driver);
        bootStrapAlert.selectBootstrapAlert();
        //bootStrapAlert.selectAutocloseableSuccessMessage();
        Thread.sleep(2000);
        bootStrapAlert.selectNormalSuccessMessage();
        Thread.sleep(4000);
    }
}
