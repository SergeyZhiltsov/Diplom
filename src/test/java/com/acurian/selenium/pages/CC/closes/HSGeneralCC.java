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
			
	
	public final String titelExpected_NoPIIemail = "We're glad the location is convenient for you.\n" +
			"\n" +
			"The last step is to provide information about the doctors who are currently treating, or have previously treated, your Type 2 Diabetes and related health conditions so we can request your medical records and send them to the study doctor.\n" +
			"\n" +
			"Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
			"\n" +
			"To start this process, you will need to provide an email address. What email address should we use:";
	
	
	public final String titleExpected_IND = "We're glad the location is convenient for you.\n" +
			"\n" +
			"The last step is to provide information about the doctors who are currently treating, or have previously treated, your %s so we can send your medical records to the study doctor. Please complete all details required on the next screen.\n" +
			"\n" +
			"Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
			"\n" +
			"You will need to provide us with an email address to start this process. What email address should we use:";
	
	
	
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    
   // @FindBy(xpath = "//div[@class='text_email_container']/input[@class='input-text']")
   // WebElement emailBox;
    
    @FindBy(xpath = "//div[@class='text_email_container']/input[@type='text']")
    WebElement emailBox;
    
  
    
    @FindBy(xpath = "//input[@id='answersQSC9111.rawAnswer']")
    WebElement emailBoxT2Dia;
    

    public HSGeneralCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralCC waitForPageLoad(String StudyIndication) {
        String titleExpectedMod = String.format(titleExpected, StudyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    @Step
    public HSGeneralCC waitForPageLoadInd(String StudyIndication) {
        String titleExpectedMod = String.format(titleExpected_IND, StudyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    @Step
    public HSGeneralCC waitForPageLoadT2DM() {
        String titleExpectedMod = String.format(titelExpected_NoPIIemail);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }
    
    @Step
    public HSGeneralCC typeEmail(String text) {
        typeText(emailBox, text);
        return this;
    }
    
    @Step
    public HSGeneralCC typeEmailAut(String text) {
        typeText(emailBox, text);
        return this;
    }

    @Step
    public HSGeneralCC typeEmail_T2Dia(String text) {
        //typeTextWithoutClear(ageMig, text);
        typeText(emailBoxT2Dia, text);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
