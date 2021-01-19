package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JQueryDualListBoxPage {

    private WebDriver driver;
    private By pickListField = By.cssSelector(".pickData");
    private By addButton = By.className("pAdd");
    private By addAllButton = By.xpath("//button[contains(text(),'Add All')]");
    private By removeButton = By.cssSelector(".pRemove");
    private By removeAllButton = By.cssSelector(".pRemoveAll");
    private By pickListResult = By.cssSelector(".pickListResult");
    private By jsLink = By.xpath("//a[contains(text(),'JQuery List Box')]");

    public JQueryDualListBoxPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectJQueryListBox(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(jsLink));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectItem(String item){
        Select objSelect = new Select(driver.findElement(pickListField));
        objSelect.selectByVisibleText(item);
    }

    public void add(){
        driver.findElement(addButton).click();
    }

    public void verifyResult(){
        Select oSelect = new Select(driver.findElement(pickListResult));
        List<WebElement> elementsList = oSelect.getOptions();

        //System.out.println(elementsList.size());

        for (WebElement element: elementsList){
            System.out.println("Items in result list = " + element.getText());
        }

        System.out.println("Result list size = " + elementsList.size());
    }

    public void addAllItems(){
        driver.findElement(addAllButton).click();
    }

    public void addItem(String item){
        selectItem(item);
        add();
    }

    public void removeItem(String item){
        Select objSelect = new Select(driver.findElement(pickListResult));
        objSelect.selectByVisibleText(item);
        driver.findElement(removeButton).click();
    }

    public void removeAllItem(){
        driver.findElement(removeAllButton).click();
    }
}
