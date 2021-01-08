package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TablePagination {

    private WebDriver driver;
    private By tablePaginationLink = By.xpath("//*[text()='Table Pagination']");

    public TablePagination(WebDriver driver){
        this.driver = driver;
    }

    public void selectTablePagination(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(tablePaginationLink));
    }

    // simple version - all table page tabs are displayed
    public void paginationWithForLoop() {//throws InterruptedException {

        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        int paginationSize = driver.findElements(By.cssSelector("#myPager>li>a")).size();
        System.out.println("No of Pages = " + (paginationSize - 2));

        List<String> tableDataC1 = new ArrayList<String>();

        for (int i=2; i<paginationSize; i++){

            // select pagination page
            String paginationSelector = "#myPager>li:nth-child("+i+")>a";
            driver.findElement(By.cssSelector(paginationSelector)).click();

           // add firstColumn element to list
           //List<WebElement> firstColumnElements = driver.findElements(By.cssSelector("#myTable>tr>td:nth-child(2)"));  --- get all record
            List<WebElement> firstColumnElements = driver.findElements(By.cssSelector("tr[style='display: table-row;']>td:nth-child(1)"));

            // for each element add text to list
            for(WebElement element: firstColumnElements){
               tableDataC1.add(element.getText());
            }
        }

        // count the size of the list
        int actualCount = tableDataC1.size();
        System.out.println("Total Number of items : " + tableDataC1.size());

        //located the number of record
        String displayCountString = driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > p:nth-child(2)")).getText();
        String[] displayedText = displayCountString.split(" ");
        String dCount = displayedText[3];
        System.out.println("Number of Record count : " + dCount);
        int displayedCount = Integer.parseInt(dCount);

        //Actual count VS Displayed Count
        if(actualCount == displayedCount){
            System.out.println("Actual row count = Displayed count");
        }else{
            System.out.println("Actual row count != Displayed count");
        }
    }

    public void printData(){
        int rowCount = driver.findElements(By.xpath("//*[@id='myTable']/tr")).size();
        System.out.println("Number of row = " + rowCount);

        int colCount = driver.findElements(By.xpath("//*[@id='myTable']/tr[1]/td")).size();
        System.out.println("Number of col = " + colCount);

        String first_part = "//*[@id='myTable']/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i=1; i<rowCount; i++){

            for (int j=1; j<colCount; j++){
                String finalXpath = first_part+i+second_part+j+third_part;
                String Table_Data = driver.findElement(By.xpath(finalXpath)).getText();
                System.out.println(Table_Data + " ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    // Table page number not displayed completely
    public void paginationDynamic(){//} throws InterruptedException {
        //Thread.sleep(1000);

        //WebDriverWait wait = new WebDriverWait(driver,1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myTable")));

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        // find all data from column1
        List<WebElement> firstColumnElements = driver.findElements(By.cssSelector("tr[style='display: table-row;']>td:nth-child(1)"));

        List<String> columnData1 = new ArrayList<String>();

        //click the next button until it reach last page
        for (WebElement element: firstColumnElements){
            columnData1.add(element.getText());
        }

        String nextButton= driver.findElement(By.cssSelector("a[class='next_link']")).getAttribute("style");
        System.out.println("Current next style = " + nextButton);

        while (!nextButton.contains("none")){
            driver.findElement(By.cssSelector("a[class='next_link']")).click();
          firstColumnElements = driver.findElements(By.cssSelector("tr[style='display: table-row;']>td:nth-child(1)")); //

            columnData1 = new ArrayList<String>(); // not need - must test
            for (WebElement element: firstColumnElements){
                columnData1.add(element.getText());
            }

            nextButton= driver.findElement(By.cssSelector("a[class='next_link']")).getAttribute("style");
            System.out.println("Current next style = " + nextButton);
        }

        // count the size of the list
        int actualCount = columnData1.size();
        System.out.println("Total Number of items : " + columnData1.size());

        //located the number of record
        String displayCountString = driver.findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > p:nth-child(2)")).getText();
        String[] displayedText = displayCountString.split(" ");
        String dCount = displayedText[3];
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


