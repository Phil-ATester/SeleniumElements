package com.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUpModal {

    private WebDriver driver;
    private By windowPopupModalLink = By.xpath("//a[contains(text(),'Window Popup Modal')]");
    private By followOnTwitterBTN = By.xpath("//a[contains(text(),'Follow On Twitter')]");
    private By followUsOnFacebookBTN = By.xpath("//*[contains(text(),'Like us On Facebook')]");

    public WindowPopUpModal(WebDriver driver){
        this.driver = driver;
    }

    public void selectWindowPopupModal(){
        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", driver.findElement(windowPopupModalLink));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectFollowOnTwitterButton() throws InterruptedException {

        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.findElement(followOnTwitterBTN).click();

        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        //Window popup
        Set<String> handler = driver.getWindowHandles();

        System.out.println("list size = " + handler.size());

        Iterator<String> iterator = handler.iterator();

        String parent = iterator.next();
        System.out.println("Parent window id = " + parent);
        String child = iterator.next();
        System.out.println("Child window id = " + child);

        //switch to popup window
        driver.switchTo().window(child);
        System.out.println("Child window popup title =  " + driver.getTitle());
        driver.close();

        //switch back to main window
        driver.switchTo().window(parent);
        System.out.println("Parent window title = " + driver.getTitle());
    }

    public void selectFollowOnFacebookButton() throws InterruptedException {
        switchToPopUp(followUsOnFacebookBTN);
    }

    public void switchToPopUp(By path) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(path).click();

        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        //Window popup
        Set<String> handler = driver.getWindowHandles();

        System.out.println("list size = " + handler.size());

        Iterator<String> iterator = handler.iterator();

        String parent = iterator.next();
        System.out.println("Parent window id = " + parent);
        String child = iterator.next();
        System.out.println("Child window id = " + child);

        System.out.println("Parent window title = " + driver.getTitle());

        //switch to popup window
        driver.switchTo().window(child);
        System.out.println("Child window popup title =  " + driver.getTitle());
        driver.close();

        //switch back to main window
        driver.switchTo().window(parent);
        System.out.println("Parent window title = " + driver.getTitle());
    }
    
}
