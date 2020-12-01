package com.seleniumeasy.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    private WebDriver driver;

    @FindBy (css="input[value='Male'][name='optradio']")
    private WebElement optMaleRadioButton;

    @FindBy (css="input[value='Female'][name='optradio']")
    private WebElement optFemaleRadioButton;

    @FindBy (css = "button#buttoncheck")
    private WebElement checkValueBtn;

    @FindBy (css = "p.radiobutton")
    private WebElement checkValueMessage;

    @FindBy (css = "a[href*='radiobutton-demo']")
    private WebElement radioButtonDemoTxt;

    @FindBy (css="input[value='Male'][name='gender']")
    private WebElement genderMaleRadioButton;

    @FindBy (css="input[value='Female'][name='gender']")
    private WebElement genderFemaleRadioButton;

    @FindBy (xpath="//input[@name='ageGroup' and @value='0 - 5']")
    private WebElement lowerAgeRangeRadioButton;

    @FindBy (xpath="//input[@name='ageGroup' and @value='5 - 15']")
    private WebElement mediumAgeRangeRadioButton;

    @FindBy (xpath="//input[@name='ageGroup' and @value='15 - 50']")
    private WebElement highAgeRangeRadioButton;

    @FindBy (xpath="//button[text()='Get values']")
    private WebElement getValueBtn;

    @FindBy (xpath = "//*[@class='groupradiobutton']")
    private WebElement getValueMessage;

    public RadioButtonPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectRadioButtonDemo(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", radioButtonDemoTxt);
    }

    public void selectMaleRB(){
        optMaleRadioButton.click();
    }

    public void selectFemaleRB(){
        optFemaleRadioButton.click();
    }

    public void selectCheckValueButton(){
        checkValueBtn.click();
    }

    public String getCheckValueMessage(){
        return checkValueMessage.getText();
    }

    public void selectMaleGroupRB(){
        genderMaleRadioButton.click();
    }

    public void selectFemaleGroupRB(){
        genderFemaleRadioButton.click();
    }

    public void selectLowRB(){
        lowerAgeRangeRadioButton.click();
    }

    public void selectMediumRB(){
        mediumAgeRangeRadioButton.click();
    }

    public void selectHighRB(){
        highAgeRangeRadioButton.click();
    }

    public void selectGetValueButton(){
        getValueBtn.click();;
    }

    public String getValueMessage(){
        return getValueMessage.getText();
    }

}
