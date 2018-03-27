package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.BasePage;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverExperiencedHeartRelatedMedicalCondOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.DoYouSufferFromLbpPageOLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS extends MainPageOLS{

    public final String titleExpected = "Have you undergone any of the following heart-related medical procedures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouUndergoneAnyOfFollowingHeartRelatedProcOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
