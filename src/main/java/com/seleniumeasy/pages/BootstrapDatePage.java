package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapDatePage {

    private WebDriver driver;

    @FindBy (how = How.XPATH, using ="//*[text()='Bootstrap Date Picker']")
    private WebElement bootstrapDatePicker;

    @FindBy (how = How.CSS, using = "#sandbox-container1>div>input")
    private WebElement singleDateField;

    @FindBy (how = How.XPATH, using = "//*[@id='datepicker']//input[1]")
    private WebElement startDate;

    @FindBy (how = How.XPATH, using = "//*[@id='datepicker']//input[2]")
    private WebElement endDate;

    @FindBy (how = How.XPATH, using ="//*[@class='datepicker-days']")
    private WebElement calander;

    @FindBy (how = How.XPATH, using = "//*[@class='datepicker-days']//tbody//tr//td[@class='day']")
    private WebElement days;

    @FindBy (how = How.XPATH, using ="//*[@class='datepicker-days']//th[@class='datepicker-switch']")
    private WebElement month;

    @FindBy (how = How.XPATH, using ="//*[@class='datepicker-days']//th[@class='prev']")
    private WebElement prevMonthArrow;

    @FindBy (how = How.XPATH, using ="//*[@class='datepicker-days']//th[@class='next']")
    private WebElement nextMonthArrow;

    private By rightArrow = By.xpath ("//*[@class='datepicker-days']//th[@class='next']");
    private By leftArrow = By.xpath ("//*[@class='datepicker-days']//th[@class='pev']");
    private String day_FORMAT = "";

    public BootstrapDatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectBootstrapDatePicker(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", bootstrapDatePicker);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void setDate(WebElement element,String day, String month, String year){
        element.sendKeys(day, month, year);
    }

    public void selectDate(String day, String month, String year){
        singleDateField.sendKeys(day +"/"+ month + "/" + year);
    }

    public void open(){
        if (!isCalanderOpen()){
            startDate.click();
        }
    }

    public boolean isCalanderOpen(){
        return calander.isDisplayed();
    }

    public void chooseMonth(LocalDate date){
        //get current date
        LocalDate currentPeriod = getCurrentPeriod();

        //compare current with destination
        Long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date);

        //decide how many arrow to use...
        By arrow = (monthsAway < 0) ? leftArrow : rightArrow;

        for (int i=0; i<Math.abs(monthsAway); i++){
            driver.findElement(arrow).click();
        }

    }

    public LocalDate getCurrentPeriod(){
         String[] currentPeriod = month.getText().split(" ");
         return LocalDate.of(Integer.parseInt(currentPeriod[1]),
                 Month.valueOf(currentPeriod[0].toUpperCase()),
                 LocalDate.now().getDayOfMonth());
    }

    public void chooseDate(int dayOfMonth){
        // class == day and text() == dayOfMonth
        //By Locator = By.xpath(format(day_FORMAT, dayOfMonth));

        By locator = By.xpath("//*[@class='datepicker-days']//td[@class='day']");
        List<WebElement> datesElements = driver.findElements(locator);
        Iterator<WebElement> itr = datesElements.iterator();
        while(itr.hasNext()){
            if (itr.next().getText().contentEquals(String.valueOf(dayOfMonth))){
                itr.next().click();
                break;
            }
        }

    }

    public LocalDate getSelectedDate(){
        return LocalDate.of(2020,5,2);
    }

    public LocalDate chooseDate(LocalDate date){
        open();
        chooseMonth(date);
        chooseDate(date.getDayOfMonth());
        return getSelectedDate();
    }



}
