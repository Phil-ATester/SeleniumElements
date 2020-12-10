package com.seleniumeasy.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AjaxFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (xpath = "//input[@id='title']")
    private WebElement nameTxtBox;

    @FindBy (xpath = "//textarea[@id='description']")
    private WebElement commentTxtArea;

    @FindBy (id="btn-submit")
    private WebElement submitBtn;

    @FindBy (xpath = "//*[@id='submit-control']")
    private  WebElement submitMessage;

    @FindBy (xpath = "//*[text()='Ajax Form Submit']")
    private WebElement ajaxFormText;


    public AjaxFormPage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectAjaxFormSubmit(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ajaxFormText);
    }

    public void setName(String name){
        nameTxtBox.sendKeys(name);
    }

    public void setComment (String comment){
        commentTxtArea.clear();
        commentTxtArea.sendKeys(comment);
    }

    public void clickSubmitButton(){
        submitBtn.click();
    }

    public String getProgressMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@src='LoaderIcon.gif']")));
        return submitMessage.getText();
    }

    public String getSuccessMessage(){

        /*
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
                fluentWait.until(new Function<WebDriver, WebElement>(){
                    public
                })
*/

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@src='LoaderIcon.gif']")));
        return submitMessage.getText();
    }

}
