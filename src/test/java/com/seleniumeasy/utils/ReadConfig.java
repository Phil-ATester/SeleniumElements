package com.seleniumeasy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){

        File src = new File("./resources/properties/config.properties");


        try{
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        }catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL(){ return properties.getProperty("baseURL"); }

    public String getChromePath(){ return properties.getProperty("chromePath"); }

    public String getIEPath(){ return properties.getProperty("iEPath"); }

    public String getFireFoxPath(){ return properties.getProperty("fireFoxPath"); }

}
