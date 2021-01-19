package com.seleniumeasy.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlerts {

    private WebDriver driver;

    private By javaScriptClickMeBtn = By.xpath("//*[text() ='Java Script Alert Box']//following-sibling::div//button[text()='Click me!']");
    private By jsLink = By.xpath("//a[contains(text(),'Javascript Alerts')]");
    private By javaScriptConfirmBoxClickMeButton = By.xpath("//*[text() ='Java Script Confirm Box']//following-sibling::div//button[text()='Click me!']");
    private By clickForPromptBoxButton = By.xpath("//*[contains(text(),'Click for Prompt Box')]");

    public JavaScriptAlerts(WebDriver driver){
        this.driver = driver;
    }

    public void selectJSAlertLink(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(jsLink));
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectAlertBoxButton(){
        // TODO: need a wait for page to load or element

        driver.findElement(javaScriptClickMeBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Message = " + alert.getText());
        alert.accept();
    }

    public void alertButton(String choice){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Message = " + alert.getText());

        if(choice.contentEquals("OK")){
            alert.accept();
        }else if(choice.contentEquals("Cancel")){
            alert.dismiss();
        }
    }

    public void selectConfirmAlertButton(String option){

        driver.findElement(javaScriptConfirmBoxClickMeButton).click();
        alertButton(option);

        System.out.println("Select Alert Option : " + driver.findElement(By.cssSelector("#confirm-demo")).getText());
    }

    public void selectPromptBoxButton(String value){
        driver.findElement(clickForPromptBoxButton).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();

        System.out.println("Enter Text : " + driver.findElement(By.cssSelector("#prompt-demo")).getText());
    }



}
