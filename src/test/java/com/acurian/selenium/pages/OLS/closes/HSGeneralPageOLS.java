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
            "Next Steps:\n" +
            "On the next screen, please provide information about the doctors who are currently treating, or have previously treated, your %s.\n" +
            "You will need to complete the medical authorization form, then you will be asked to connect your health data.\n" +
            "\n" +
            "This information will be sent to the study site to allow them to evaluate you for the research study.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
    
    public final String titleExpected1 = "We're glad the location is convenient for you.\n" +
			"\n" +
            "Next Steps:\n" +
			"On the next screen, please provide information about the doctors who are currently treating, or have previously treated, your Type 2 Diabetes and related health conditions.\n" +
            "You will need to complete the medical authorization form, then you will be asked to connect your health data.\n" +
			"\n" +
            "This information will be sent to the study site to allow them to evaluate you for the research study.\n" +
            "\n" +
			"Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleRaExpected = "Your medical records related to your Low Back Pain, Diabetes, Arthritis, " +
            "Rheumatoid Arthritis history are required for the study doctor to evaluate you for participation. " +
            "In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    public HSGeneralPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralPageOLS waitForPageLoad(String siteIndication) {
        String titleExpectedMod = String.format(titleExpected, siteIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    
    @Step
    public HSGeneralPageOLS waitForPageLoadT2DM() {
        String titleExpectedMod = String.format(titleExpected1);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
