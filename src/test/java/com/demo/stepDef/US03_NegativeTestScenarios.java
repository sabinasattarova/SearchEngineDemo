package com.demo.stepDef;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import com.demo.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import static org.junit.Assert.assertEquals;

public class US03_NegativeTestScenarios {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YahooSearchPage yahooSearchPage = new YahooSearchPage();
    YahooResultPage yahooResultPage = new YahooResultPage();

    public static String searchEng;

    @Given("user is on the {string} page")
    public void user_is_on_the_page(String searchEngine) {
        BrowserUtils.openSearchEnginePage(searchEngine);
        searchEng = searchEngine;

    }

    @When("user searches for {string} data")
    public void user_searches_for_data(String randomData) {

        switch (searchEng){
            case "google": googleSearchPage.searchBox.sendKeys(randomData + Keys.ENTER);
                break;
            case "yahoo":
                BrowserUtils.waitForClickability(yahooSearchPage.searchBox, 3); // yahoo page is taking time to load
                yahooSearchPage.searchBox.sendKeys(randomData + Keys.ENTER);
                break;
        }

    }


    @Then("user should see {string} message in the result in google")
    public void user_should_see_message_in_the_result_in_google(String errorMsg) {
        assertEquals(errorMsg, googleResultPage.errorMsg.getText());
    }

    @Then("user should see {string} message in the result in yahoo")
    public void user_should_see_message_in_the_result_in_yahoo(String errorMsg) {
        assertEquals(errorMsg, yahooResultPage.errorMsg.getText());
    }



}
