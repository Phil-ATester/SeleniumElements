package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDropPage {

    private WebDriver driver;
    private By jsLink = By.xpath("//a[contains(text(),'Drag and Drop')]");

    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectDragAndDrop(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(jsLink));
    }

    public void dragItem(String item) {
        String selectedItem = "//*[@id='todrag']//span[contains(text(),'" + item + "')]";
        WebElement fromElement = driver.findElement(By.xpath(selectedItem));
        WebElement toElement = driver.findElement(By.xpath("//*[@id='mydropzone']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(fromElement, toElement).build().perform();

        List<WebElement> droppedList = driver.findElements(By.xpath("//*[@id='droppedlist']"));
        System.out.println("Dropped List Size : " + droppedList.size());
    }
}
