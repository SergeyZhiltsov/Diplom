package com.acurian.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {


    @FindBy(xpath = "//ul[@id='nav']/li//strong[text()='Vlad Kholod']")
    WebElement loginName;



    public MainPage(){
        PageFactory.initElements(getDriver(), this);
    }



    public void waitForLoginVisible(){
        driverWait.waitforVisibility(loginName);
    }

}
