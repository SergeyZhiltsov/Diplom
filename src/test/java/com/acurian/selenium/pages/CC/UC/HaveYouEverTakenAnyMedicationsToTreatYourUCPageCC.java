package com.acurian.selenium.pages.CC.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC extends MainPageCC {

    public final String titleExpected = "Have you ever taken any medications to treat or manage your ulcerative colitis?\n" +
            "Please think about medications that you take now or that you have taken in the past.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTakenAnyMedicationsToTreatYourUCPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
