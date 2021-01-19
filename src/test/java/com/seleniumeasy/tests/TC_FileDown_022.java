package com.seleniumeasy.tests;

import com.seleniumeasy.pages.FileDownLoadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TC_FileDown_022 {

    WebDriver driver;
    File folder;

    @BeforeMethod
    public void setup(){

        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        //chrome setup:
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", folder.getAbsolutePath());
        options.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("resources/drivers/chromedriver"))
                .usingAnyFreePort()
                .build();
        options.merge(capabilities);
        driver = new ChromeDriver(service, options);
    }

    @Test
    public void fileDownloadTest_001() throws InterruptedException {

        driver.get("https://www.seleniumeasy.com/test/");

        FileDownLoadPage fileDownLoadPage = new FileDownLoadPage(driver);
        fileDownLoadPage.selectFileDownLink();
        Thread.sleep(2000);
        fileDownLoadPage.enterData("This is a Test");
        fileDownLoadPage.selectGenerateFile();
        fileDownLoadPage.selectDownload();

        Thread.sleep(2000);

        //once Downloaded

        File filesList[] = folder.listFiles();
        // directory not empty
        Assert.assertTrue(filesList.length>0);
        // file not empty
        for(File file: filesList){
            Assert.assertTrue(file.length()>0);
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

        //delete file
        for (File file : folder.listFiles()){
            file.delete();
        }
        folder.delete();

    }
}
