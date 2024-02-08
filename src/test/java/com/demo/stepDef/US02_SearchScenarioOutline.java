package com.demo.stepDef;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import com.demo.utils.BrowserUtils;
import com.demo.utils.ConfigReader;
import com.demo.utils.SearchUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class US02_SearchScenarioOutline {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YahooSearchPage yahooSearchPage = new YahooSearchPage();
    YahooResultPage yahooResultPage = new YahooResultPage();
    private static String searchEng = ConfigReader.getProperty("searchEngine");


    @When("user searches for {string} capital")
    public void user_searches_for_capital(String country) {

        switch (searchEng) {
            case "google":
                SearchUtils.sendKeys("capital of " + country, googleSearchPage.searchBox);
                break;
            case "yahoo": BrowserUtils.waitForClickability(yahooSearchPage.searchBox, 3);
                SearchUtils.sendKeys("capital of " + country, yahooSearchPage.searchBox);
        }

    }


    @Then("user should see {string} in the result")
    public void user_should_see_in_the_result(String capital) {

        switch (searchEng) {
            case "google":
                assertEquals(capital, googleResultPage.resultText.getText());
                break;
            case "yahoo":
                BrowserUtils.waitForClickability(yahooResultPage.firstResult, 5); //to ensure page fully loaded and
                // stable before performing assertion
                assertEquals(capital, yahooResultPage.capitalResult.getAttribute("title"));
        }
    }


    @Then("first returned item must be result of calculation {string}")
    public void first_returned_item_must_be_result_of_calculation(String result) {
        switch (searchEng) {
            case "google":
                assertEquals(result, googleResultPage.calculationResult.getText());
                break;

            case "yahoo":
                BrowserUtils.waitForClickability(yahooResultPage.firstResult, 5);//to ensure page fully loaded and stable before performing assertion
                assertEquals(result, yahooResultPage.percentCalculationResult.getText());
        }
    }


}
