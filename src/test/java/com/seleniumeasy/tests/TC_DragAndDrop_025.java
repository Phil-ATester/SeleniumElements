package com.seleniumeasy.tests;

import com.seleniumeasy.pages.DragAndDropPage;
import org.testng.annotations.Test;

public class TC_DragAndDrop_025 extends BaseClass{

    @Test
    public void TestDragAndDrop() throws InterruptedException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.selectDragAndDrop();
        Thread.sleep(1000);
        dragAndDropPage.dragItem("Draggable 2");
        Thread.sleep(5000);
    }
}
