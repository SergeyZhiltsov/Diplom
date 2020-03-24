package com.acurian.selenium.pages.CC.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DigestiveConditionsAffectDiabetesPageCC extends MainPageCC {

    public final String titleExpected = "Have you ever been diagnosed with any of the following digestive conditions which affect some people with diabetes?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public DigestiveConditionsAffectDiabetesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DigestiveConditionsAffectDiabetesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DigestiveConditionsAffectDiabetesPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
