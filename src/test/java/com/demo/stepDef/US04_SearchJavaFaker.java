package com.demo.stepDef;

import com.demo.pages.GoogleResultPage;
import com.demo.pages.GoogleSearchPage;
import com.demo.pages.YahooResultPage;
import com.demo.pages.YahooSearchPage;
import com.demo.utils.ConfigReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US04_SearchJavaFaker {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
    YahooSearchPage yahooSearchPage = new YahooSearchPage();
    YahooResultPage yahooResultPage = new YahooResultPage();
    private static String searchEng = ConfigReader.getProperty("searchEngine");
    public static String inputData;

    @When("user searches for {string} data in google")
    public void user_searches_for_data_in_google(String inputData) {
        Faker faker = new Faker();


        this.inputData = inputData;

    }
    @Then("user should see {string} message in the result in google page")
    public void user_should_see_message_in_the_result_in_google_page(String errorMsg) {

    }



}
