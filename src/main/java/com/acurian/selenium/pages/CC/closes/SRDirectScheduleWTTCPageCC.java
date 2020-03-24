package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SRDirectScheduleWTTCPageCC extends MainPageCC{

    //Synexus/Radiant Direct Schedule Warm Transfer Tracking Close
    public final String titleExpected = "For Call Center Tracking of Direct Scheduling - Please select one of the following dispositions:";

    @FindBy(xpath = "//div[@class='question_text']/span")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public SRDirectScheduleWTTCPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SRDirectScheduleWTTCPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public SRDirectScheduleWTTCPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
