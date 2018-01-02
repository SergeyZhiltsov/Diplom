package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.closes.SynexusQualifiedClose4356PageOLS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralCC extends MainPageCC{

    //MDD
    public final String titleExpected = "Your medical records related to your %s history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public HSGeneralCC() {
        PageFactory.initElements(getDriver(), this);
    }

/*    @Step
    public HSGeneralCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }*/

    @Step
    public HSGeneralCC waitForPageLoad(String StudyIndication) {
        String titleExpectedMod = String.format(titleExpected, StudyIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }


    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
