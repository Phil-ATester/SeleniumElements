package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JQueryProgressBar {

    private WebDriver driver;
    private By jQueryDownlandLink = By.xpath("//a[text()='JQuery Download Progress bars']");
    private By downloadBTN = By.cssSelector("#downloadButton");
    private By progressbar = By.cssSelector("#progressbar");
    private By progressLabel = By.cssSelector(".progress-label");
    private By cancelBTN = By.cssSelector(".ui-dialog-buttonset>button");


    public JQueryProgressBar(WebDriver driver){
        this.driver = driver;
    }

    public void selectJQueryDownload(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(jQueryDownlandLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void selectDownload() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(downloadBTN).click();

    }

    public void selectCloseButton() throws InterruptedException {
        // Fluent Waits   --- more control than Implicit Wait
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);


        //wait for the presence of the text to appear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(progressbar));

        String value = driver.findElement(progressbar).getAttribute("aria-valuenow");
        if (value.contains("100")){
            System.out.println("download complete");
            driver.findElement(cancelBTN).click();
        }else{
            System.out.println("not complete download");
        }

        Thread.sleep(4000);
        //driver.findElement(cancelBTN).click();
    }

    public void showProgress(){
        String valueNow = driver.findElement(By.cssSelector("#progressbar")).getAttribute("aria-valuenow");
        System.out.println("Progress value: " + valueNow);

        String completed = driver.findElement(By.cssSelector(".progress-label")).getText();
        if (completed.contains("Complete!")){
            System.out.println("Download Completed");
        }
    }

}
