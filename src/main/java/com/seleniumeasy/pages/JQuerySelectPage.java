package com.seleniumeasy.pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class JQuerySelectPage {

    private WebDriver driver;

    @FindBy (xpath = "//*[text()='JQuery Select dropdown']")
    private WebElement jquerySelectText;

    @FindBy (xpath = "//*[@id='select2-country-container']//parent::span")
    private WebElement countrydd;

    @FindBy (css = "#select2-country-results>li")
    private WebElement countryL;

    @FindBy (css = ".select2-search__field")
    private WebElement statedd;

    @FindBy (xpath = "//*[@id='select2-a08t-container']")  //*[start-with(@id, 'select2-') and end-with(@id, '-container')]
    private WebElement therrtoriesdd;


    @FindBy (xpath = "//span[starts-with(@id, 'select2-')]")
    private WebElement therrtoriesdd2;

    @FindBy (css = ".files")
    private WebElement categorydd;

    private JavascriptExecutor js;

    public JQuerySelectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void selectJQuerySelect(){
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", jquerySelectText);

        //driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
    }

    public void selectCountry(String country) {

        //WebDriverWait wait = new WebDriverWait(driver, 2000);
        //wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='select2-country-container']//parent::span")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //System.out.println("after wait/before dropdown click");

        //Wait wait = new FluentWait<WebDriver>(driver).withTimeout(50,TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        countrydd.click();
        //driver.findElement(By.xpath("//*[@id='select2-country-container']//parent::span")).click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-country-results']//li")));

        List<WebElement> elements = driver.findElements(By.cssSelector("#select2-country-results>li"));
        select_values(elements, country);

        //js = (JavascriptExecutor)driver;
        //List<WebElement> elements = (List<WebElement>) js.executeScript("return j.Query.find('name=select2-country-results')");

    }

    public String getCountry(){
        return driver.findElement(By.xpath("//*[@id='select2-country-container']")).getText();
    }

    public void select_values(List<WebElement> option_List,String value){

        for(WebElement element: option_List){
            if(element.getText().equals(value)){ ;
                    System.out.println("Selected Element: " + element.getText());
                    element.click();
                    break;
            }
        }

         /*
        //Iterator<WebElement> countryList = (Iterator<WebElement>) driver.findElements(By.cssSelector("#select2-country-results>li"));
        Iterator<WebElement> i = countryList.iterator();

        while (i.hasNext()){
            WebElement el = i.next();
            if (el.getText().equals(country)){
                    el.click();
             }
        }
        */
    }

    public void selectState(String state){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-search__field")));

        statedd.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select2-results__option")));

        List<WebElement> elements = driver.findElements(By.cssSelector(".select2-results__option"));
        //*[@id="select2-tfcb-results"]//li

        select_values(elements, state);
    }

    /*
    public void select_values2(List<WebElement> option_List,List<String> values) {

        for (WebElement element : option_List) {
            for (String value: values) {
                if (element.getText().equals(value)) {
                    System.out.println(element.getText());
                    element.click();
                    break;
                }
            }
        }

    }
     */

    public ArrayList<String> getStates(){

        ArrayList<String> selectedList = new ArrayList<String>();

        List<WebElement> statesSelectedList = driver.findElements(By.xpath("//*[@class='select2-selection__choice']"));

        for (WebElement state: statesSelectedList){
            System.out.println("item selected: " + state.getAttribute("title"));
            selectedList.add(state.getAttribute("title"));
        }

        return selectedList;
    }

    public void selectUSTerritory(String name){
        List<WebElement> elist = driver.findElements(By.xpath("//span[starts-with(@id, 'select2-')]"));
        elist.get(1).click();

        //driver.findElements(By.xpath("//span[starts-with(@id, 'select2-')][2]"));

        List<WebElement> usTorritories = driver.findElements(By.xpath("//*[@class='select2-results__options']//li"));


        for (WebElement state: usTorritories){
            String e = state.getAttribute("aria-disabled");
            if (e == null && state.getText().equals(name)) {
                System.out.println("name: " + state.getText());
                state.click();
                break;
            }else if (e !=null && e.equalsIgnoreCase("true")){
                System.out.println("State is not selectable: " + state.getText());
                break;
            }
        }

        //select_values(usTorritories, name);
    }

    public void selectLanguage(String language){
        List<WebElement> fileList = driver.findElements(By.cssSelector("#files>optgroup>option"));

        select_values(fileList, language);
    }
}
