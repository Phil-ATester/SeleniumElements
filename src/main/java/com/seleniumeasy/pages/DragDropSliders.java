package com.seleniumeasy.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragDropSliders {

    private WebDriver driver;
    private By sliderLink = By.xpath("//a[text()='Drag & Drop Sliders']");

    public DragDropSliders (WebDriver driver){
        this.driver = driver;
    }

    public void selectDragAndDropSliderLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(sliderLink));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    public void selectSlider(String Option){
        driver.findElement(By.cssSelector(".range")).click();
    }

    public void moveSlider(int value){
        for(int i=1; i < value; i++ ){
            driver.findElement(By.cssSelector(".range")).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void dragAndDropToFrom(){
        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.xpath(""));
        WebElement to = driver.findElement(By.xpath(""));

        builder.dragAndDrop(from, to).perform();
    }

    public void dragAndDropSlider1(){
        WebElement slider = driver.findElement(By.cssSelector("#slider1>div>input"));

        Actions action = new Actions(driver);

        action.dragAndDropBy(slider, 386, 393).perform();
        slider.click();

    }

    public void clickOnCo(int x, int y){
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);

        actions.moveByOffset(x, y).click().perform();
        actions.release();
    }
}
