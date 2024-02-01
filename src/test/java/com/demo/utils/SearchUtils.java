package com.demo.utils;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class SearchUtils {

    private SearchUtils(){}

    private static GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private static YahooSearchPage yahooSearchPage = new YahooSearchPage();
    private static GoogleResultPage googleResultPage = new GoogleResultPage();
    private static YahooResultPage yahooResultPage = new YahooResultPage();



    public static void sendKeys(String key, WebElement locator){
        locator.sendKeys(key + Keys.ENTER);
    }

    public static void dismissAlert(WebElement locator){
        locator.click();
    }

    /**
     * WIP method that should type data into google or yahoo search pages dynamically with provided information
     * @param searchInput => data that you are searching for
     */
    public static void searchFor(String searchInput) {
        switch (ConfigReader.getProperty("searchEngine")) {
            case "google":
                googleSearchPage.searchBox.sendKeys(searchInput + Keys.ENTER);
                break;
            case "yahoo":
                BrowserUtils.waitForClickability(yahooSearchPage.searchBox, 3); // yahoo page is taking time to load
                yahooSearchPage.searchBox.sendKeys(searchInput + Keys.ENTER);
                break;
        }
    }




}
