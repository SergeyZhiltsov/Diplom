package com.acurian.selenium.pages.CC.pediatric;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
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
    
    public final String titleExpectedIBD = "Your medical records related to your %s history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please provide the contact information of both the specialist who treats you for your Ulcerative Colitis, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public HSCrohns2PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSCrohns2PageCC waitForPageLoad(String ibdStudy) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public HSCrohns2PageCC waitForPageLoadIBD(String ibdStudy) {
        waitForPageLoadMain(titleText, titleExpectedIBD);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
