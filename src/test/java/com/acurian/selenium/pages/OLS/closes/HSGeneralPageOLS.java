package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralPageOLS extends MainPageOLS{

    //3159
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
    		"\n" +
    		"The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.";
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    public HSGeneralPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralPageOLS waitForPageLoad(String Siteindicator) {
        String titleExpectedMod = String.format(titleExpected, Siteindicator);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
