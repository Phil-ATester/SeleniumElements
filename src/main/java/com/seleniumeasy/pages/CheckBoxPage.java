package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckBoxPage {

    private WebDriver driver;

    @FindBy (css = "input#isAgeSelected")
    private WebElement checkbox;

    @FindBy (xpath = "//*[@id='txtAge']")
    private WebElement successMessageTxt;

    @FindBy (css = "#check1")
    private WebElement checkBtn;

    @FindBy (css = "#isChkd")
    private WebElement buttonTxt;

    @FindBy (xpath = "//*[text()='Checkbox Demo']")
    private WebElement checkBoxDemoText;

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCheckBoxDemo(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", checkBoxDemoText);
    }

    public void selectCheckBox(){
        //if (!checkbox.isSelected()){
        checkbox.click();
        //}
    }

    public String getMessage(){
        return successMessageTxt.getText();
    }

    public boolean isMessagePresent() {
        return successMessageTxt.isDisplayed();
    }

    public void selectCheckButton(){
        //if (isCheckedField.getAttribute("value").equals("false")){
        checkBtn.click();
        //}
    }

    public String getButtonValue(){
        return checkBtn.getAttribute("value");
    }

    public void selectCheckboxOption(String num){
        String path = "//*[text()='Option " + num + "']//input";  //input[@class="cb1-element"]
        driver.findElement(By.xpath(path)).click();
    }

}
