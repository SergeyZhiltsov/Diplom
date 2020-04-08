package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS extends MainPageBlinx {

//    public final String titleExpected = "You reported that you have liver problems.\n" +
//            "Which of the following have you been diagnosed with?\n" +
//            "Please select all that apply.";

    public final String titleExpected = "Do you have any of the following liver conditions?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS_BLINX)
    List<WebElement> checkBoxList;

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
