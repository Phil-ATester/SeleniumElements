package com.seleniumeasy.tests;

import com.seleniumeasy.utils.ReadConfig;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;

    ReadConfig readConfig = new ReadConfig();
    public String baseURl = readConfig.getApplicationURL();

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){

        switch(br){
            case "IE":
                System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
                driver = new InternetExplorerDriver();
                System.out.println("Internet Explorer Browser selected");
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
                driver = new FirefoxDriver();
                System.out.println("FireFox Browser selected");
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("No Browser Selected");
                break;
        }

        driver.get(baseURl);

        // set the amount of time to wait for a page to load to complete before it throws an error
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);  // time , Timeout unit

        logger = Logger.getLogger("Selenium easy");
        PropertyConfigurator.configure("Log4j.properties");

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String testName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./resources/Screenshots/" + testName + ".png"));
        System.out.println("Screenshot Taken");
    }

}
