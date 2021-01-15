package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProgressBar {

    private WebDriver driver;
    private By progressBarModal = By.xpath("//a[contains(text(),'Progress Bar Modal')]");
    private By showDialogPrimaryBTN = By.cssSelector(".btn-primary");
    private By modalTitle = By.cssSelector(".modal-header>h3");
    private By showDialogSuccessBTN = By.cssSelector(".btn-success");
    private By showDialogSuccessSettingBTN = By.cssSelector(".btn-warning");


    public ProgressBar (WebDriver driver){
        this.driver = driver;
    }

    public void selectProgressBarModal(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(progressBarModal));
            //driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectSimpleDialog() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(showDialogPrimaryBTN)));
        //driver.findElement(showDialogPrimaryBTN).click();
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-primary')]")));
        btn.click();
        btn.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'modal fade')]")));
        System.out.println("Dialog Title = " + driver.findElement(modalTitle).getText());
    }

    public void selectCustomDialog(){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(showDialogSuccessBTN)));
        driver.findElement(showDialogSuccessBTN).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        System.out.println("Success Dialog Title = " + driver.findElement(modalTitle).getText());
    }

    public void selectCustomSettingDialog(){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(showDialogSuccessSettingBTN)));
        driver.findElement(showDialogSuccessSettingBTN).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        System.out.println("Success Dialog Title = " + driver.findElement(modalTitle).getText());
    }

    public void selectDialogButton(String option){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        switch (option) {
            case "Simple":
                System.out.println("Simple");
                driver.findElement(showDialogPrimaryBTN).click();
                break;
            case "Custom" :
                System.out.println("Custom");
                driver.findElement(showDialogSuccessBTN).click();
                break;
            case "CustomSetting" :
                driver.findElement(showDialogSuccessSettingBTN).click();
                break;
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        System.out.println("Dialog Title = " + driver.findElement(modalTitle).getText());

    }

}
