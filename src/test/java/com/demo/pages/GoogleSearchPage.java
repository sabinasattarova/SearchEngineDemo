package com.demo.pages;

import com.demo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage{


    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@jsname='itVqKe']")
    public WebElement clearBtn;







}
