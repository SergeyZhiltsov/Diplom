package com.acurian.selenium.pages.CC.AS_4319;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingSymptomsMoreThanOnceAWeekCC extends MainPageCC{

    public final String titleExpected = "Do you experience any of the following symptoms more than once a week?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public FollowingSymptomsMoreThanOnceAWeekCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingSymptomsMoreThanOnceAWeekCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingSymptomsMoreThanOnceAWeekCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
