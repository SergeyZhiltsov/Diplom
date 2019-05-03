package com.acurian.selenium.pages.OLS.IBD_Crohns_UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ReviewMedicalRecordsCrohnsDiagnosisPageOLS extends MainPageOLS {

	public final String titleExpected = "The study doctor will need to review your medical records.\n" +
            "\n" +
            "Are you able to provide medical records confirming your Crohn’s diagnosis, or provide approval for the study doctor to access your medical records?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public ReviewMedicalRecordsCrohnsDiagnosisPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ReviewMedicalRecordsCrohnsDiagnosisPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ReviewMedicalRecordsCrohnsDiagnosisPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
