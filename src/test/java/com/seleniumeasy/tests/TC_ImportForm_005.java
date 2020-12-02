package com.seleniumeasy.tests;

import com.seleniumeasy.pages.FormPage;
import org.testng.annotations.Test;

public class TC_ImportForm_005 extends BaseClass {

    @Test
    public void testImportForm_001() throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        formPage.selectInputFormText();
        formPage.setFirstName("Tom");
        formPage.setLastName("Brown");
        formPage.setEmail("Tom@Gmail.com");
        formPage.setPhoneNum("(835)123-1234");
        formPage.setAddress("Address A");
        formPage.setCity("ORSF");
        formPage.selectState("California");
        formPage.setZipCode("4423423443");
        formPage.setWebsite("http://www.Test1.com");
        formPage.selectHosting("no");
        formPage.setComment("This is a Test");
        formPage.clickSendButton();
    }
}
