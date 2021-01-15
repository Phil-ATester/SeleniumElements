package com.seleniumeasy.tests;

import com.seleniumeasy.pages.WindowPopUpModal;
import org.testng.annotations.Test;

public class TC_WindowPopUp_019 extends BaseClass{

    @Test
    public void testWindowPopUp() throws InterruptedException {
        WindowPopUpModal windowPopUpModal = new WindowPopUpModal(driver);
        windowPopUpModal.selectWindowPopupModal();
        //windowPopUpModal.selectFollowOnTwitterButton();
        windowPopUpModal.selectFollowOnFacebookButton();
    }
}
