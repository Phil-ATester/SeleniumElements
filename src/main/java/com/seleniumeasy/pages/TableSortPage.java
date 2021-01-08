package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableSortPage {

    private WebDriver driver;
    private By tableSortLink = By.xpath("//a[text()='Table Sort & Search']");

    private By searchField = By.xpath("//*[@id='example_filter']/label/input");
    private By table = By.xpath("//*[@id='example']//tbody//tr");


    public TableSortPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectTableFilter(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(tableSortLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void searchRecords(String option) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchField).sendKeys(option);

        Thread.sleep(1000);

        List<WebElement> searchRecords = driver.findElements(table);

        for (WebElement record: searchRecords){
            System.out.println("Record = " + record.getText());
        }

        System.out.println("Number of Record = " + searchRecords.size());
    }

    public void paginationDynamic() throws InterruptedException {
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        // find all data from column1
        List<WebElement> nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));

        List<String> names = new ArrayList<String>();

        //click the next button until it reach last page
        for (WebElement element: nameElements){
            //System.out.println("element in list " + element.getText());
            names.add(element.getText());
        }

        String nextButton= driver.findElement(By.cssSelector("#example_next")).getAttribute("class");
        System.out.println("Current next style = " + nextButton);

        while (!nextButton.contains("disabled")){
            driver.findElement(By.cssSelector("#example_next")).click();
            nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));

            //names = new ArrayList<String>();
            for (WebElement element: nameElements){
                //System.out.println("element in list " + element.getText());
                names.add(element.getText());
            }

            nextButton= driver.findElement(By.cssSelector("#example_next")).getAttribute("class");;
            //System.out.println("Current next style = " + nextButton);
        }

        // count the size of the list
        int actualCount = names.size();
        System.out.println("Total Number of items : " + names.size());

        //located the number of record
        String displayCountString = driver.findElement(By.cssSelector("#example_info")).getText();
        String[] displayedText = displayCountString.split(" ");
        String dCount = displayedText[5];
        System.out.println("Number of Record count : " + dCount);
        int displayedCount = Integer.parseInt(dCount);

        //Actual count VS Displayed Count
        if(actualCount == displayedCount){
            System.out.println("Actual row count = Displayed count");
        }else{
            System.out.println("Actual row count != Displayed count");
        }
    }
}
