package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BootstrapProgressBar {

    private WebDriver driver;

    private By downloadBTN = By.cssSelector("#cricle-btn");
    private By progressField = By.cssSelector(".percenttext");
    private By bootstrapProgessLink = By.xpath("//a[text()='Bootstrap Progress bar']");

    public BootstrapProgressBar(WebDriver driver){
        this.driver = driver;
    }

    public void selectBootstapProgessLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(bootstrapProgessLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void selectDownloadButton(){
        driver.findElement(downloadBTN).click();
    }

    public void isDownloadSuccessfull(){
        //String progress = driver.findElement(By.cssSelector(".slice")).getAttribute("class");
        String progress = driver.findElement(By.cssSelector(".percenttext")).getText();
        while (!progress.contains("100")){
            System.out.println(driver.findElement(By.cssSelector(".percenttext")).getText());
            progress =  driver.findElement(By.cssSelector(".percenttext")).getText();;
           // System.out.println("class value: " + progress);
        }
        System.out.println("Download Successfull");
    }
}
