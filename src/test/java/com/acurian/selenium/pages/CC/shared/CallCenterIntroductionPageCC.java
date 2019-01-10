package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.constants.URLs;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CallCenterIntroductionPageCC extends MainPageCC {

    public final String titleExpected = "Thank you for calling Acurian Health's research study line. My name is AUTOTEST AUTOTEST and I'll be able to help you today. Are you calling about a research study?\n" +
            "\n" +
            "Agent notes:\n" +
            "If at any point during the call, the respondent indicates that he or she is providing information on behalf of someone else, follow the call center SOP for obtaining verbal consent before continuing with the call.\n" +
            "Always select \"Learn more about matching to clinical trials\" unless prompted by a caller to pick another selection.";

    public final String titleExpectedDYS = "Thank you for calling Acurian Health's research study line. My name is AUTOTEST AUTOTEST and I'll be able to walk you through our questionnaire today.\n" +
            "\n" +
            "May I ask your name please?";


    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='radio_btns_container']//label")
    List<WebElement> radioButtonsList;

    @FindBy(id = "activate_debug")
    WebElement activateDebugLink;

    public CallCenterIntroductionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CallCenterIntroductionPageCC waitForPageLoad() {
        waitForAnimation();
        driverWait.waitforVisibility(titleText);
        return this;
    }

    @Step
    public CallCenterIntroductionPageCC activateDebugOnProd(String environment) {
        if (environment.equals("PRD")) {
            activateDebugLink.click();
            typeAndAcceptAlert(URLs.CODE_FOR_DEBUG_CC);
            acceptAlert();
        }
        waitForAnimation();
        return this;
    }

    @Step
    public CallCenterIntroductionPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
