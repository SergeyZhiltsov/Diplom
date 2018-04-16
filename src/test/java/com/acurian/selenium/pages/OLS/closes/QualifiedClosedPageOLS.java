package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClosedPageOLS extends MainPageOLS{

    //%s = ID variable
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
    		"We will forward your contact information to the doctor’s office that you selected so they may contact you for further evaluation using the phone number you provided. Or you can schedule your appointment now by calling 855-382-9810.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    public QualifiedClosedPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClosedPageOLS waitForPageLoad() {
        String titleExpectedMod = String.format(titleExpected, "625263");
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
