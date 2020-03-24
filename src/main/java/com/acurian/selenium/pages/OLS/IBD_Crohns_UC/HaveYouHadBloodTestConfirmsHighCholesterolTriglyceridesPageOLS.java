package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS extends MainPageOLS {

    public final String titleExpected = "Have you had a blood test that confirms you have high cholesterol or high triglycerides?\n" +
            "Please select all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouHadBloodTestConfirmsHighCholesterolTriglyceridesPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}