package com.seleniumeasy.tests;

import com.seleniumeasy.pages.AjaxFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AjaxForm_006 extends BaseClass{

    @Test
    public void TestAjaxForm(){
        AjaxFormPage ajaxFormPage = new AjaxFormPage(driver);
        ajaxFormPage.selectAjaxFormSubmit();
        ajaxFormPage.setName("Name1");
        ajaxFormPage.setComment("This is a Test");
        ajaxFormPage.clickSubmitButton();
        Assert.assertTrue(ajaxFormPage.getProgressMessage().contains("Ajax Request is Processing"));
        Assert.assertEquals(ajaxFormPage.getSuccessMessage(), "Form submited Successfully!", "submit unsuccessfully");
        //System.out.println("Progress bar Message: " + ajaxFormPage.getProgressMessage());
        //System.out.println("Success Message: " + ajaxFormPage.getSuccessMessage());
    }

}
