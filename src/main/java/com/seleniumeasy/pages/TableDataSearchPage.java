package com.seleniumeasy.pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableDataSearchPage {

    private WebDriver driver;
    private By tableDataSearchLink = By.xpath("//a[text()='Table Data Search']");
    private By filterField = By.xpath("//*[@id='task-table-filter']");

    public TableDataSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectTableDataSearch(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(tableDataSearchLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void setFilter(String name){
        driver.findElement(filterField).click();
        driver.findElement(filterField).sendKeys(name);
    }

    // To-do -- remove thread.sleep
    public void confirmSearch(String name) throws InterruptedException {
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

        //enter filter field
        //driver.findElement(filterField).clear();
        //driver.findElement(filterField).sendKeys(name);
        setFilter(name);

        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        List<WebElement> filterList = driver.findElements(By.xpath("//*[@id='task-table']//tbody//tr"));

        List<String> displayList = new ArrayList<String>();

        for (WebElement element: filterList){
            String style = element.getAttribute("Style");
            if (!style.contains("display: none")){
                System.out.println("Filter Items = " + element.getText());
                displayList.add(element.getText());
            }
        }

        System.out.println("Filtered List Size = " +displayList.size());

    }

    public void filterUser(String name, String filterType) throws InterruptedException {
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        //click filter button
        driver.findElement(By.cssSelector(".btn-filter")).click();

        //select username
        switch (filterType){
            case "username":
                driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(name);
                break;
            case "firstname":
                driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(name);
                break;
            case "lastname":
                driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(name);
                break;
        }

        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        List<WebElement> filterList = driver.findElements(By.xpath("//*[@class='table']//tbody/tr"));

        List<String> displayList = new ArrayList<String>();

        for (WebElement element: filterList){
            String style = element.getAttribute("Style");
            if (!style.contains("display: none")){
                System.out.println("Filter User = " + element.getText());
                displayList.add(element.getText());
            }
        }

        System.out.println("Filtered List Size = " +displayList.size());

    }
}
