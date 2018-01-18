package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralCC extends MainPageCC{

    //MDD
    public final String titleExpected = "Your medical records related to your %s history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";
    
  //RA
    public final String titleExpectedRA = "Your medical records related to your %s history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility." +
            "\n" +
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
