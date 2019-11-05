package com.acurian.selenium.pages.OLS.Crohns;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS extends MainPageOLS {
    public final String titleExpected = "As part of your Crohn's disease diagnosis, have you ever had any of the following procedures done?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    @Step
    public AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AsPartOfYourCronsDiseaseDiagnosisFollowingProceduresOLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
