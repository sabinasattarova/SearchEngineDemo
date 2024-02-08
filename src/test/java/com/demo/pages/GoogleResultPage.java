package com.demo.pages;

import com.demo.utils.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage extends BasePage {

    public GoogleResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@jsname='UWckNb']//h3")
    public WebElement firstResult;

    @FindBy(xpath = "//div[@class='kp-header']//a")
    public WebElement resultText;

    @FindBy(css = "#cwos")
    public WebElement calculationResult;

    @FindBy(xpath = "//div[@class='card-section']//p")
    public WebElement errorMsg;

    @FindBy(xpath = "(//div[@class='lv7K9c'])[1]")
    public WebElement alertStaySignOut;
    //in case you are in the guest mode and there might a pop-up that will block you from doing anything
}
