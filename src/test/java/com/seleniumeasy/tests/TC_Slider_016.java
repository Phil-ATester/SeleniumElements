package com.seleniumeasy.tests;

import com.seleniumeasy.pages.DragDropSliders;
import org.testng.annotations.Test;

public class TC_Slider_016 extends BaseClass{

    @Test
    public void testSlider001() throws InterruptedException {
        DragDropSliders dragDropSliders = new DragDropSliders(driver);
        dragDropSliders.selectDragAndDropSliderLink();
        Thread.sleep(1000);
        //dragDropSliders.dragAndDropCo1();
        dragDropSliders.clickOnCo(823, 392);
        //Thread.sleep(3000);
        //dragDropSliders.clickOnCo(806, 485);
        Thread.sleep(8000);
    }
}
