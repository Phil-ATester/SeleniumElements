package com.seleniumeasy.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class BootStrapAlert {

    private WebDriver driver;
    private By bootstrapAlertLink = By.xpath("//a[contains(text(),'Bootstrap Alert')]");

    private By autocloseBTN = By.cssSelector("#autoclosable-btn-success");
    private By autocloseAlert = By.cssSelector(".alert-autocloseable-success");
    private By normalSuccessBTN = By.cssSelector("#normal-btn-success");
    private By normalSuccessAlert = By.cssSelector(".alert-normal-success");



    public BootStrapAlert(WebDriver driver){
        this.driver = driver;
    }

    public void selectBootstrapAlert(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(bootstrapAlertLink));
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectAutocloseableSuccessMessage() throws InterruptedException {
            Thread.sleep(1000);

            driver.findElement(autocloseBTN).click();

            //check alert is displayed
             System.out.println("Message displayed = " + driver.findElement(autocloseAlert).isDisplayed());

             //Thread.sleep(3000);
            //confirm message closes after 5 second
             WebDriverWait wait = new WebDriverWait(driver, 5000);
             wait.until(ExpectedConditions.invisibilityOfElementLocated(autocloseAlert));

             System.out.println("Message displayed = " + driver.findElement(autocloseAlert).isDisplayed());
    }

    public void selectNormalSuccessMessage(){
        //WebDriverWait wait = new WebDriverWait(driver, 1000);
        //wait.until(ExpectedConditions.elementToBeClickable(normalSuccessBTN));

        driver.findElement(normalSuccessBTN).click();
        System.out.println("Success Message is displayed: " + driver.findElement(normalSuccessAlert).isDisplayed());

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(normalSuccessAlert));
        driver.findElement(By.cssSelector(".alert-normal-success>button")).click();

        System.out.println("Success Message is displayed: " + driver.findElement(normalSuccessAlert).isDisplayed());
    }

}
