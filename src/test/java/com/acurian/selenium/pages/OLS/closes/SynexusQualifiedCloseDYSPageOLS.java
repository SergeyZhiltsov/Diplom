package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class SynexusQualifiedCloseDYSPageOLS extends MainPageOLS{

    //%s = ID variable
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
    		"\n" +
    		"The next step is to schedule an appointment with the study doctor. You can schedule your appointment directly by calling 1-844-438-6150. Please provide the study doctor ID %s when you call. If we don’t hear from you, we will call you at the number provided to schedule your appointment.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    public SynexusQualifiedCloseDYSPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SynexusQualifiedCloseDYSPageOLS waitForPageLoad(String facilityCode) {
        String titleExpectedMod = String.format(titleExpected, facilityCode);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
