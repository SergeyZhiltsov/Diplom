package com.acurian.selenium.pages.OLS.AUTI_3973;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.LBP_2108.WhatTypeOfHealthcarePageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class InThePast3MonthsHaveYouExperienced_OLS extends MainPageOLS{

    public final String titleExpected = "The following can be common difficulties for people with autism.\n" +
    		"In the past three months, have you experienced any of the following?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public InThePast3MonthsHaveYouExperienced_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public InThePast3MonthsHaveYouExperienced_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public InThePast3MonthsHaveYouExperienced_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
