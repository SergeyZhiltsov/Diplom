package com.acurian.selenium.pages.CC.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingMedicationsToTreatYourRACC extends MainPageCC{

    public final String titleExpected = "Are you currently taking any of the following medications to treat your RA?\n" +
            "Agent Note: Read medications in the following way: \"Aralen, also known as chloroquine\" etc.\n" +
    		"Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public FollowingMedicationsToTreatYourRACC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingMedicationsToTreatYourRACC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingMedicationsToTreatYourRACC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
