package com.acurian.selenium.pages.CCBlinxTest;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AcurianHealthResearchStudyLine extends MainPageBlinx {

    public final String titleExpected = "Thank you for calling Acurian Health's research study line. My name is Sergey Zhyltsov and I'll be able to help you today. Are you calling about a research study?\n" +
            "\n" +
            "Agent notes:\n" +
            "If at any point during the call, the respondent indicates that he or she is providing information on behalf of someone else, follow the call center SOP for obtaining verbal consent before continuing with the call.\n" +
            "Always select \"Learn more about matching to clinical trials\" unless prompted by a caller to pick another selection.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public AcurianHealthResearchStudyLine waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AcurianHealthResearchStudyLine clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }


    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
