package com.acurian.selenium.pages.CC.IBD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ReviewMedicalRecordsCrohnsDiagnosisPageCC extends MainPageCC {

    public final String titleExpected = "The study doctor will need to review your medical records.\n" +
            "\n" +
            "Are you able to provide medical records confirming your Crohn’s diagnosis, or provide approval for the study doctor to access your medical records?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public ReviewMedicalRecordsCrohnsDiagnosisPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ReviewMedicalRecordsCrohnsDiagnosisPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ReviewMedicalRecordsCrohnsDiagnosisPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
