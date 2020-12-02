package com.seleniumeasy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormPage {

    private WebDriver driver;

    @FindBy (xpath = "//a[text()='Input Form Submit']")
    private WebElement importFormTxt;

    @FindBy (xpath = "//input[@name='first_name']")
    private  WebElement firstNameTxtBox;

    @FindBy (xpath = "//input[@name='last_name']")
    private  WebElement lastNameTxtBox;

    @FindBy (xpath = "//input[@name='email']")
    private  WebElement emailTxtBox;

    @FindBy (xpath = "//input[@name='phone']")
    private  WebElement phoneTxtBox;

    @FindBy (xpath = "//input[@name='address']")
    private  WebElement addressTxtBox;

    @FindBy (xpath = "//input[@name='city']")
    private  WebElement cityTxtBox;

    @FindBy (xpath = "//select[@name='state']")
    private  WebElement stateDropDownList;

    @FindBy (xpath = "//input[@name='zip']")
    private  WebElement zipTxtBox;

    @FindBy (xpath = "//input[@name='website']")
    private  WebElement websiteTxtBox;

    @FindBy (xpath = "//input[@name='hosting']")
    private List<WebElement> hostingRadioButtons;

    @FindBy (xpath ="//*[@name='comment']")
    private WebElement commentTxtBox;

    @FindBy (xpath = "//button[@class='btn btn-default']")
    private WebElement sendButton;

    public FormPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectInputFormText(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", importFormTxt);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    public void setFirstName(String firstName){
        firstNameTxtBox.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameTxtBox.sendKeys(lastName);
    }

    public void setEmail(String email){
        emailTxtBox.sendKeys(email);
    }

    public void setPhoneNum(String num){
        phoneTxtBox.sendKeys(num);
    }

    public void setAddress(String addr){
        addressTxtBox.sendKeys(addr);
    }

    public void setCity(String city){
        cityTxtBox.sendKeys(city);
    }

    public void selectState(String state){
        Select select = new Select(stateDropDownList);
        select.selectByVisibleText(state);
    }

    public void setZipCode(String zCode){
        zipTxtBox.sendKeys(zCode);
    }

    public void setWebsite(String website){
        websiteTxtBox.sendKeys(website);
    }

    public void selectHosting (String option){
       for (WebElement hosting : hostingRadioButtons)
       if (hosting.getAttribute("value").contains(option)){
            hosting.click();
       }
    }

    public void setComment (String note){
        commentTxtBox.clear();
        commentTxtBox.sendKeys(note);
    }

    public void clickSendButton(){
        sendButton.click();
    }

}
