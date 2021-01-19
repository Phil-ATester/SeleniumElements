package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataListFilterPage {

    private WebDriver driver;
    private By searchField = By.cssSelector("#input-search");

    public DataListFilterPage(WebDriver driver){
        this.driver = driver;
    }

}
