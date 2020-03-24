package com.acurian.selenium.pages.CC.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WarmTransferGmegaPageCC extends MainPageCC{

    //public final String titleExpected = "For TMS Tracking - Please select one of the following dispositions:";

    public final String titleExpected = "Great, please hold for just a moment. If we should get disconnected for any reason, please do not worry; we will pass your information on to the study doctor's office and they will just get in contact with you directly. [Attempt to call site]\n"+
            "\n"+
            "Dial the displayed phone number: 123-456-7899\n"+
            "\n"+
            "The agent should give the site phone number to the caller, if the caller is requesting it.\n"+
            "\n"+
            "If site answers: Hello, this is AUTOTEST AUTOTEST calling from Acurian. May I please speak to the person in your office who is responsible for scheduling initial patient appointments for the %STUDY_REF_NAME_FOR_REFERRED_PROTO%? [If the site is unsure which study you are calling about, refer to protocol name and number RA01_Generic (RA01_Generic).]";


    public final String titleExpectedPRD = "Great, please hold for just a moment. If we should get disconnected for any reason, please do not worry; we will pass your information on to the study doctor's office and they will just get in contact with you directly. [Attempt to call site]\n"+
        "\n"+
        "Dial the displayed phone number: 123-456-7899\n"+
        "\n"+
        "The agent should give the site phone number to the caller, if the caller is requesting it.\n"+
        "\n"+
        "If site answers: Hello, this is AUTOTEST AUTOTEST calling from Acurian. May I please speak to the person in your office who is responsible for scheduling initial patient appointments for the %STUDY_REF_NAME_FOR_REFERRED_PROTO% study? [If the site is unsure which study you are calling about, refer to protocol name and number RA01_Generic (RA01_Generic).]";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WarmTransferGmegaPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WarmTransferGmegaPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WarmTransferGmegaPageCC waitForPageLoadPRD() {
        waitForPageLoadMain(titleText, titleExpectedPRD);
        return this;
    }

    @Step
    public WarmTransferGmegaPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
