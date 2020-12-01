package com.seleniumeasy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {

    private WebDriver driver;

    @FindBy (xpath = "//*[text()='Simple Form Demo']")
    private WebElement simpleFormDemoText;

    @FindBy (xpath = "//input[@id='user-message'] ")
    private WebElement messageTxt;

    @FindBy (xpath = "//button[text()='Show Message'] ")
    private WebElement showMessageButton;

    @FindBy (css ="#display")
    private WebElement messageLabel;

    @FindBy (css = "#sum1")
    private WebElement valueATxt;

    @FindBy (css = "#sum2")
    private WebElement valueBTxt;

    @FindBy (xpath = "//button[text()='Get Total']")
    private WebElement totalButton;

    @FindBy (css ="#displayvalue")
    private WebElement totalSum;

    public SimpleFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSimpleFormDemo(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", simpleFormDemoText);
    }

    public void setMessage(String message){
        messageTxt.sendKeys(message);
    }

    public void selectShowMessageButton(){
        showMessageButton.click();
    }

    public String getMessage(){
        return messageLabel.getText();
    }

    public void setAValue(String valueA){
        valueATxt.sendKeys(valueA);
    }

    public void setBValue(String valueB){
        valueBTxt.sendKeys(valueB);
    }

    public void selectGetTotalButton(){
        totalButton.click();
    }

    public String getSumValue(){
        return totalSum.getText();
    }

}
