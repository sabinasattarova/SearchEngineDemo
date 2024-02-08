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








}
