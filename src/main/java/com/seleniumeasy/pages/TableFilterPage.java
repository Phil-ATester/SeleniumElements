package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableFilterPage {

    private WebDriver driver;
    private By tableFilterLink = By.xpath("//a[text()='Table Filter ']");

    public TableFilterPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectTableFilter(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(tableFilterLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void displayedRecords(){
        List<WebElement> recordList = driver.findElements(By.cssSelector(".table>tbody>tr"));

        List<String> filterRecords = new ArrayList<String>();

        for (WebElement record: recordList){
            String style = record.getAttribute("Style");
            if (!style.contains("display: none")){
                System.out.println("Record = " + record.getText());
                filterRecords.add(record.getText());
            }
        }

        System.out.println("Filter List Size = " + filterRecords.size());
    }

    public void filterRecord(String option) throws InterruptedException {
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[contains(@class,'btn-filter')][text()='" + option + "']")).click();

        Thread.sleep(2000);
        displayedRecords();
    }
}
