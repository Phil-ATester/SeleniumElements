package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownPage {

    private WebDriver driver;

    @FindBy (xpath = "//*[text()='Select Dropdown List']")
    private WebElement selectDropListTxt;

    @FindBy (css ="select#select-demo")
    private WebElement dropDownList;

    @FindBy (css="p.selected-value")
    private WebElement dayMessage;

    @FindBy (xpath="//*[@id='multi-select']")
    private WebElement multiList;

    @FindBy (css="p.getall-selected")
    private WebElement optionSelectedResult;

    @FindBy (xpath ="//*[@id='printMe']")
    private WebElement firstSelectedBtn;

    @FindBy (xpath="//*[@id='printAll']")
    private WebElement getAllSelectedBtn;

    public SelectDropDownPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDropDownDemo(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", selectDropListTxt);
    }

    public void selectDay(String day){
        Select dropdown = new Select(dropDownList);
        dropdown.selectByVisibleText(day);
    }

    public String getDaySelected(){
        return dayMessage.getText();
    }

    public void selectCountry(String name){
        Select countryDropDown = new Select(multiList);
        countryDropDown.selectByVisibleText(name);
    }
/*
    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
        List <WebElement> selectedElement = findDropDownElement().getAllSelectedOptions();
        return selectedElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }
*/
    public String getOptionsSelected(){
        return optionSelectedResult.getText();
    }

    public void selectFirstSelectedBtn(){
        firstSelectedBtn.click();
    }

    public void setGetAllSelectedBtn(){
        getAllSelectedBtn.click();
    }

}
