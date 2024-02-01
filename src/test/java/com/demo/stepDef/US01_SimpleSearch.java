package com.demo.stepDef;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import com.demo.utils.BrowserUtils;
import com.demo.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.junit.Assert.*;

public class US01_SimpleSearch {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YahooSearchPage yahooSearchPage = new YahooSearchPage();
    YahooResultPage yahooResultPage = new YahooResultPage();
    private static String searchEng = ConfigReader.getProperty("searchEngine");



    @Given("user is on the {string} search page")
    public void user_is_on_the_search_page(String searchPage) {

        BrowserUtils.openSearchPage(searchPage);

    }

    @When("user searches for {string}")
    public void user_searches_for(String searchInput) {

      switch (searchEng){
            case "google": googleSearchPage.searchBox.sendKeys(searchInput + Keys.ENTER);
                break;
            case "yahoo":
                BrowserUtils.waitForClickability(yahooSearchPage.searchBox, 3); // yahoo page is taking time to load
                yahooSearchPage.searchBox.sendKeys(searchInput + Keys.ENTER);
            break;
        }

    }

    @Then("first returned item must contain {string}")
    public void first_returned_item_must_contain(String keyword) {


        switch (searchEng){
            case "google":  assertTrue(googleResultPage.firstResult.getText().contains(keyword));
                break;
            case "yahoo":  BrowserUtils.waitForClickability(yahooResultPage.firstResult, 3); //to ensure page fully loaded and stable before performing assertion
            assertTrue(yahooResultPage.firstResult.getText().contains(keyword));
        }



    }

    @Then("title name must contain {string}")
    public void title_name_contain_be(String keyword) {
        //double check that search engine is returning related results
     BrowserUtils.verifyTitleContains(keyword);

    }






}
