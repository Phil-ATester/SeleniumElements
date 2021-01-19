package com.seleniumeasy.tests;

import com.seleniumeasy.pages.DualListBoxPage;
import org.testng.annotations.Test;

public class TC_ListBox_023 extends BaseClass{

    @Test
    public void ListBoxTest_001() throws InterruptedException {
        DualListBoxPage dualListBoxPage = new DualListBoxPage(driver);
        dualListBoxPage.selectBootstrapListBox();
        Thread.sleep(1000);
        dualListBoxPage.selectItems("bootstrap-duallist", "left");
        dualListBoxPage.selectItems("Morbi leo risus", "left");
        dualListBoxPage.moveRight();
        Thread.sleep(2000);
        dualListBoxPage.listSize("list-right");
        dualListBoxPage.listSize("list-left");
        Thread.sleep(5000);
    }

    @Test
    public void ListBoxTest_002() throws InterruptedException {
        DualListBoxPage dualListBoxPage = new DualListBoxPage(driver);
        dualListBoxPage.selectBootstrapListBox();
        Thread.sleep(1000);
        dualListBoxPage.selectItems("Cras justo odio", "right");
        dualListBoxPage.moveLeft();
        Thread.sleep(2000);
        dualListBoxPage.listSize("list-right");
        dualListBoxPage.listSize("list-left");
        Thread.sleep(5000);
    }
}
