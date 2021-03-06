package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS extends MainPageOLS {

//    public final String titleExpected = "You reported that you have liver problems.\n" +
//            "Which of the following have you been diagnosed with?\n" +
//            "Please select all that apply.";
    public final String titleExpected = "Do you have any of the following liver conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

//    @Step
//    public WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS waitForPageLoad() {
//        waitForPageLoadMain(titleText, titleExpected);
//        return this;
//    }

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_LiverDiseaseOLS waitForPageLoad() {
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
