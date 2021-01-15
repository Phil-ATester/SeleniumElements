package com.seleniumeasy.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BootstrapModal {

    private WebDriver driver;
    private By singleLaunchModalButton = By.xpath("//a[contains(@href,'myModal0')]");
    private By bootstrapModalLink = By.xpath("//a[contains(text(),'Bootstrap Modals')]");
    private By multiBootstrapModalButton = By.xpath("//a[@href='#myModal']");

    private By multiModalTitle = By.xpath("//*[@id='myModal']/div/div/div[1]/h4");
    private By innerModalButton = By.xpath("//a[@href='#myModal2']");
    private By innerModalTitle = By.xpath("//*[@id='myModal2']//div//h4");
    //*[@id="myModal"]/div/div/div[3]/a

    public BootstrapModal(WebDriver driver){
        this.driver = driver;
    }

    public void selectBootstrapModal(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(bootstrapModalLink));
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectLaunchModal() { //throws InterruptedException {
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(singleLaunchModalButton).click();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myModal0']/div/div/div[1]/h4")));

        String alertMessage = driver.findElement(By.xpath(" //*[@id='myModal0']/div/div/div[1]/h4")).getText();
        System.out.println("Alert Message Title = " + alertMessage);

        driver.findElement(By.xpath("//*[@id='myModal0']//div[4]//a")).click();
    }

    public void selectMultipleModal() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(multiBootstrapModalButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(multiModalTitle));

        String alertMessage = driver.findElement(multiModalTitle).getText();
        System.out.println("Alert Message Title = " + alertMessage);

        wait.until(ExpectedConditions.visibilityOfElementLocated(innerModalButton));
        driver.findElement(innerModalButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(innerModalTitle));
        String innerTitle = driver.findElement(innerModalTitle).getText();
        System.out.println("Inner Modal Title = " + innerTitle);

        driver.findElement(By.xpath(" //*[@id='myModal2']//div[6]//a")).click();

        driver.findElement(By.xpath(" //*[@id='myModal']//div[4]//a")).click();
    }
}
