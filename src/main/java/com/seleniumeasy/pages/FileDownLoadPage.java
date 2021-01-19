package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FileDownLoadPage {

    private WebDriver driver;
    private By textField = By.cssSelector("#textbox");
    private By generateBtn = By.id("create");
    private By downloadLink = By.xpath("//*[@id='link-to-download']");
    private By fileDownloadLink = By.xpath("//a[contains(text(),'File Download')]");

    public FileDownLoadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFileDownLink(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(fileDownloadLink));
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enterData(String data) {
        driver.findElement(textField).sendKeys(data);
    }

    public void selectGenerateFile() {
        driver.findElement(generateBtn).click();
    }

    public void selectDownload(){
        driver.findElement(downloadLink).click();
    }

}
