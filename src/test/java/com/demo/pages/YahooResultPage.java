package com.demo.pages;

import com.demo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooResultPage extends BasePage{


    public YahooResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//div//h3)[2]")
    public WebElement firstResult;

    @FindBy(xpath = "(//li[@class='first']//span)[9]")
    public WebElement resultText;

    @FindBy(xpath = "//tbody//tr[1]//td[2]//div//span//b")
    public WebElement percentCalculationResult;

    @FindBy(xpath = "//*[@id=\"web\"]/ol/li/div/div[1]/p")
    public WebElement errorMsg;

    @FindBy(xpath = "//li[@class='p-r last']//a[2]")
    public WebElement capitalResult;


}
