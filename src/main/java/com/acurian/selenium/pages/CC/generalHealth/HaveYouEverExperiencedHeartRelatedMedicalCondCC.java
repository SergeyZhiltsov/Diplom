package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverExperiencedHeartRelatedMedicalCondCC extends MainPageCC {

    public final String titleExpected = "Have you ever had or suffered from any of the following heart-related events or conditions?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public HaveYouEverExperiencedHeartRelatedMedicalCondCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverExperiencedHeartRelatedMedicalCondCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverExperiencedHeartRelatedMedicalCondCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
