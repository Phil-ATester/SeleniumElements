package com.seleniumeasy.tests;

import com.seleniumeasy.pages.JavaScriptAlerts;
import org.testng.annotations.Test;

public class TC_JavaScriptAlert_021 extends BaseClass{

    @Test
    public void TestJavaScriptAlert_001() throws InterruptedException {
        JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts(driver);
        javaScriptAlerts.selectJSAlertLink();
        Thread.sleep(2000);
        javaScriptAlerts.selectAlertBoxButton();
    }

    @Test
    public void TestConfirmAlert_002 () throws InterruptedException {
        JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts(driver);
        javaScriptAlerts.selectJSAlertLink();
        Thread.sleep(1000);
        javaScriptAlerts.selectConfirmAlertButton("OK");
    }

    @Test
    public void TestPromptBoc_003() throws InterruptedException {
        JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts(driver);
        javaScriptAlerts.selectJSAlertLink();
        Thread.sleep(1000);
        javaScriptAlerts.selectPromptBoxButton("This is my first test");
    }
}
