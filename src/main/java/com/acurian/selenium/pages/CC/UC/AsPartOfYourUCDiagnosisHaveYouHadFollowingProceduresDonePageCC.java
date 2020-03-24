package com.acurian.selenium.pages.CC.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC extends MainPageCC{

    public final String titleExpected = "As part of your ulcerative colitis diagnosis, have you ever had any of the following procedures done?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AsPartOfYourUCDiagnosisHaveYouHadFollowingProceduresDonePageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
