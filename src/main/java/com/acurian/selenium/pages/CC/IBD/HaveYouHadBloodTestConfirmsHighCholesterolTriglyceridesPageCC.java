package com.acurian.selenium.pages.CC.IBD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC extends MainPageCC {
    public final String titleExpected = "Have you had a blood test that confirms you have high cholesterol or high triglycerides?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_CC)
    List<WebElement> checkBoxList;

    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}