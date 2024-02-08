package com.demo.utils;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {


    /**
     * this method will open search page based on what we store in configuration.properties file
     * @param propertiesKey => key that is defined in configuration.properties "searchEngine"
     */
    public static void openSearchPage(String propertiesKey){
        switch (ConfigReader.getProperty(propertiesKey)){
            case "google": openGooglePage();
                break;
            case "yahoo": openYahooPage();
                break;
        }
    }

    /**
     * Opens search page of an Engine that is specified in configuration.properties file property is "searchEngine"
     */
    public static void openSearchPage(){
        if (ConfigReader.getProperty("searchEngine").equals("google")){
            openGooglePage();
        }else if(ConfigReader.getProperty("searchEngine").equals("yahoo")){
            openYahooPage();
        }
    }

    /**
     * This method will open search page based on the name of the search page the is stored in configuration.properties
     * @param searchEngineName => google, yahoo
     */
    public static void openSearchEnginePage(String searchEngineName){
        switch (searchEngineName){
            case "google": openGooglePage();
                break;
            case "yahoo": openYahooPage();
                break;
        }
    }



    /**
     * Waits for provided element to be clickable
     *
     * @param element => WebElement
     * @param timeout => in seconds
     * @return => WebElement
     */
    public static void waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

       // return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * verifyTitle method verifies if the current page's title contains expected Title
     * @param expectedTitleContains => keyword
     */
    public static void verifyTitleContains(String expectedTitleContains){
        Assert.assertTrue("Actual title does NOT CONTAIN Expected Title", Driver.getDriver().getTitle().contains(expectedTitleContains));
    }

    /**
     * To refresh the WebPage
     */
    public static void refresh(){
        Driver.getDriver().navigate().refresh();
    }

    /**
     * for temporary use, while debugging
     * @param seconds => 3-5
     */
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static void openGooglePage(){ Driver.getDriver().get(ConfigReader.getProperty("google"));}
    private static void openYahooPage(){
        Driver.getDriver().get(ConfigReader.getProperty("yahoo"));
    }




}
