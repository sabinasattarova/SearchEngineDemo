package com.demo.stepDef;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import com.demo.utils.SearchUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class US04_SearchJavaFaker {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YahooSearchPage yahooSearchPage = new YahooSearchPage();
    YahooResultPage yahooResultPage = new YahooResultPage();
    private static String generatedData;
    private final Faker faker = new Faker();

    @When("user searches for {string} data in {string}")
    public void user_searches_for_data_in(String inputData, String searchEngine) {

        switch (inputData){
            case "random1": case "random2":
                generatedData = faker.phoneNumber().subscriberNumber(25);
                break;
        }

       switch (searchEngine){
            case "google":
                SearchUtils.sendKeys(generatedData, googleSearchPage.searchBox);
                break;
            case "yahoo":
                SearchUtils.sendKeys(generatedData, yahooSearchPage.searchBox);
                break;
        }
    }
    @Then("user should see {string} message in the result in {string} page")
    public void user_should_see_message_in_the_result_in_google_page(String errorMsg, String searchEngine) {

        switch (searchEngine){
            case "google":
                assertEquals(errorMsg.replace("random", generatedData), googleResultPage.errorMsg.getText());
                break;
            case "yahoo":
                assertEquals(errorMsg.replace("random", generatedData), yahooResultPage.errorMsg.getText());
                break;
        }

    }



}
