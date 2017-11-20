package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class Synexus4241DSWTC2PageCC extends MainPageCC{

    //4241 Synexus Direct Schedule Warm Transfer Close 2
    public final String titleExpected = "Great, please hold for a moment. Your patience is greatly appreciated. If we should get disconnected for any reason, please do not worry, we will pass your information on to the scheduling center and they will just get in contact with you directly.\n" +
            "[Attempt to call site] Verify that patient is hearing hold music\n" +
            "\n" +
            "Dial the displayed phone number: 855-670-2761\n" +
            "\n" +
            "If site does not answer: Do not leave a message.\n" +
            "\n" +
            "If site answers:\n" +
            "Hello, this is AUTOTEST AUTOTEST calling from the Acurian Call Center. We have a patient on the line who would like to schedule their first office visit. I'm going to bring the patient on the line.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public Synexus4241DSWTC2PageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public Synexus4241DSWTC2PageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public Synexus4241DSWTC2PageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
