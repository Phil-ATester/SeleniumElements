package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DualListBoxPage {

    private WebDriver driver;
    private By bootStrapListBoxLink = By.xpath("//a[contains(text(),'Bootstrap List Box')]");

    private By moveRightBtn = By.cssSelector(".move-right");
    private By moveLeftBtn = By.cssSelector(".move-left");

    public DualListBoxPage (WebDriver driver){
        this.driver = driver;
    }

    public void selectBootstrapListBox(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(bootStrapListBoxLink));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectItems(String option, String listbox){
        List<WebElement> elementList = driver.findElements(By.cssSelector(".list-" + listbox +">div>ul>li"));
        for(WebElement element: elementList){
            if (element.getText().contains(option)){
                element.click();
                break;
            }
        }
    }

    public void moveRight(){
        driver.findElement(moveRightBtn).click();
    }

    public void moveLeft(){
        driver.findElement(moveLeftBtn).click();
    }

    public void listSize(String list){
        List<WebElement> eList = driver.findElements(By.cssSelector("."+ list + ">div>ul>li"));
        System.out.println("Number of item in " + list + " = " + eList.size());
    }

    public void selectAll(){
        driver.findElement(By.xpath("//*[@id='listhead']/div[2]/div/a")).click();
        //*[@id="listhead"]/div[1]/div/a
    }

}
