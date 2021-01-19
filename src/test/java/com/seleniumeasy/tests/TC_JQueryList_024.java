package com.seleniumeasy.tests;

import com.seleniumeasy.pages.JQueryDualListBoxPage;
import org.testng.annotations.Test;

public class TC_JQueryList_024 extends BaseClass{


    @Test
    public void MoveItemTest_001() throws InterruptedException {
        System.out.println("First Test");
        JQueryDualListBoxPage jQueryDualListBoxPage = new JQueryDualListBoxPage(driver);
        jQueryDualListBoxPage.selectJQueryListBox();
        Thread.sleep(1000);
        jQueryDualListBoxPage.selectItem("Alice");
        jQueryDualListBoxPage.add();
        jQueryDualListBoxPage.selectItem("Sophia");
        jQueryDualListBoxPage.add();
        jQueryDualListBoxPage.selectItem("Luiza");
        jQueryDualListBoxPage.add();
        jQueryDualListBoxPage.verifyResult();
        Thread.sleep(3000);
    }

    @Test
    public void AddAllItemTest_002() throws InterruptedException {
        System.out.println("Second Test");
        JQueryDualListBoxPage jQueryDualListBoxPage = new JQueryDualListBoxPage(driver);
        jQueryDualListBoxPage.selectJQueryListBox();
        Thread.sleep(1000);
        jQueryDualListBoxPage.addAllItems();
        jQueryDualListBoxPage.verifyResult();
        Thread.sleep(3000);
    }

    @Test
    public void RemoveItemTest_003() throws InterruptedException {
        System.out.println("Third Test");
        JQueryDualListBoxPage jQueryDualListBoxPage = new JQueryDualListBoxPage(driver);
        jQueryDualListBoxPage.selectJQueryListBox();
        Thread.sleep(1000);
        jQueryDualListBoxPage.addItem("Sophia");
        jQueryDualListBoxPage.addItem("Laura");
        jQueryDualListBoxPage.addItem("Lara");
        jQueryDualListBoxPage.verifyResult();
        jQueryDualListBoxPage.removeItem("Lara");
        jQueryDualListBoxPage.verifyResult();
        Thread.sleep(2000);
    }

    @Test
    public void RemoveALLItemTest_004() throws InterruptedException {
        System.out.println("RemoveAll Test");
        JQueryDualListBoxPage jQueryDualListBoxPage = new JQueryDualListBoxPage(driver);
        jQueryDualListBoxPage.selectJQueryListBox();
        Thread.sleep(1000);
        jQueryDualListBoxPage.addAllItems();
        jQueryDualListBoxPage.verifyResult();
        jQueryDualListBoxPage.removeAllItem();
        jQueryDualListBoxPage.verifyResult();
        Thread.sleep(2000);
    }
}
