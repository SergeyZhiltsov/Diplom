package com.acurian.selenium.pages.CC.Crohns;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC extends MainPageCC {
    public final String titleExpected = "As part of your Crohn's disease diagnosis, have you ever had any of the following procedures done?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    @Step
    public AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresCC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
