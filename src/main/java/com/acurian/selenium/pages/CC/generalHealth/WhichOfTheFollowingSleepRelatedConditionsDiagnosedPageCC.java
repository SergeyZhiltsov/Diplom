package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC extends MainPageCC {
    public final String titleExpected = "You indicated that you have sleep problems.\n" +
            "Which of the following sleep-related conditions have you been diagnosed with?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfTheFollowingSleepRelatedConditionsDiagnosedPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
