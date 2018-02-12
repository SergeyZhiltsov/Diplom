package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralCC extends MainPageCC{

    //MDD
	public final String titleExpected = "We're glad the location is convenient for you.\n" +
    		"\n" +
    		"The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.";
    
  //RA
	public final String titleExpectedRA = "We're glad the location is convenient for you.\n" +
    		"\n" +
    		"The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "You will need to provide us with an email address to start this process. What email address should we use:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='text_email_container']/input[@class='input-text']")
    WebElement emailBox;
    
    

    public HSGeneralCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralCC waitForPageLoadRA() {
        waitForPageLoadMain(titleText, titleExpectedRA);
        return this;
    }

    @Step
    public HSGeneralCC waitForPageLoad(String StudyIndication) {
        String titleExpectedMod = String.format(titleExpected, StudyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    @Step
    public HSGeneralCC typeEmail(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(emailBox, text);
        return this;
    }


    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
