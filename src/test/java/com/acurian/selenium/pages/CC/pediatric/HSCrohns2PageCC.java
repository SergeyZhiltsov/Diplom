package com.acurian.selenium.pages.CC.pediatric;


import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.closes.HSGeneralCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSCrohns2PageCC extends MainPageCC{

    //3485
    public final String titleExpected = "Your medical records related to your %s history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
    		"\n" +
    		"Please provide the contact information of both the specialist who treats you for your Crohn's Disease, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.";
    
    public final String titleExpected1 = "Your medical records related to your Ulcerative Colitis history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please provide the contact information of both the specialist who treats you for your Ulcerative Colitis, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
    
    
    public final String titleExpectedIBD = "Your medical records related to your %s history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please provide the contact information of both the specialist who treats you for your Ulcerative Colitis, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleExpectedGmegaPRD = "Your medical records related to your Rheumatoid Arthritis, Arthritis, Low Back Pain, Diabetes history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";


    public final String titleExpectedGmegaSTG = "Your medical records related to your Rheumatoid Arthritis, Diabetes, Low Back Pain, Arthritis history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition. We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleExpectedGmegaQA = "Your medical records related to your Arthritis, Rheumatoid Arthritis, Diabetes, Low Back Pain history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition. We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='text_email_container']/input[@type='text']")
    WebElement emailBox;
    

    public HSCrohns2PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSCrohns2PageCC waitForPageLoad(String ibdStudy) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HSCrohns2PageCC waitForPageLoadByTitle(String title) {
        waitForPageLoadMain(titleText, title);
        return this;
    }
    
    @Step
    public HSCrohns2PageCC waitForPageLoad1() {
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }
    
    @Step
    public HSCrohns2PageCC waitForPageLoadIBD(String ibdStudy) {
        waitForPageLoadMain(titleText, titleExpectedIBD);
        return this;
    }
    
    @Step
    public HSCrohns2PageCC typeEmail(String text) {
        typeText(emailBox, text);
        return this;
    }
    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
