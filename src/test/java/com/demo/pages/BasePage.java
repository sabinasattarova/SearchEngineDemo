package com.demo.pages;

import org.openqa.selenium.WebElement;

public abstract  class BasePage {

    //explicit wait
    //common functionalities for all pages like dropDown menu
    //click functionality

    public static void dismissAlert(WebElement locator){
        locator.click();
    }


}
