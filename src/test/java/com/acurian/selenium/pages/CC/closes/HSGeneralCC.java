package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralCC extends MainPageCC{

    //MDD, RA
	public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can request your medical records and send them to the study doctor.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
	

	public final String titleExpected1 = "We're glad the location is convenient for you.\n" +
			"\n" +
			"The last step is to provide information about the doctors who are currently treating, or have previously treated, your Type 2 Diabetes and related health conditions so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
			"\n" +
			"Please be assured that your records will be kept confidential and only shared with the research facility.";
			
	
	public final String titleExpectedNoPIIemail = "We’re almost done with this questionnaire!\n\n" +
            "As the next step, please provide your email address. We will keep it confidential. Your email is required to move to the next step of the study pre-screening process.\n\n" +
            "What email address should we use?";
	
	
	public final String titleExpected_IND = "We're glad the location is convenient for you.\n" +
            "\n" +
            "The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with an email address to start this process. What email address should we use:";

    public final String titleExpected4556 = "We're glad the location is convenient for you.\n" +
            "\n" +
            "The last step is to provide information about the doctors who manage your routine care, including vaccinations, so we can request your medical records and send them to the study doctor.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
	
	
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='text_email_container']/input[@type='text']")
    WebElement emailBox;
    

    public HSGeneralCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralCC waitForPageLoadEmailNotProvided() {
        waitForPageLoadMain(titleText, titleExpectedNoPIIemail);
        return this;
    }

    @Step
    public HSGeneralCC waitForPageLoad(String studyIndication) {
        String titleExpectedMod = String.format(titleExpected, studyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public HSGeneralCC waitForPageLoadByTitle(String title) {
        waitForPageLoadMain(titleText, title);
        return this;
    }
    
    @Step
    public HSGeneralCC waitForPageLoadInd(String studyIndication) {
        String titleExpectedMod = String.format(titleExpected_IND, studyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    @Step
    public HSGeneralCC typeEmail(String text) {
        typeText(emailBox, text);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
