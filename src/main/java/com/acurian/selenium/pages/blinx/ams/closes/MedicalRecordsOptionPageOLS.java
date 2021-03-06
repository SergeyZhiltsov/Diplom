package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MedicalRecordsOptionPageOLS extends MainPageBlinx {

    private final String titleExpected1 = "Why are Medical Records Important?";
    private final String titleExpected2 = "It is important for the study doctor to have your full health history in a timely manner. Your medical records are the best way to provide the study doctor with this very important health information.\n\n" +
            "The information contained in your medical records is confidential. If you agree to let us access your medical records, please know that your records will be kept secure. They will only be shared with the study doctor's office.\n\n" +
            "Your medical record information is likely stored in multiple locations, so this service not only helps us protect your safety and health during a study by providing the study doctor with all your health information, but also will help speed up your first appointment at the study doctor's office. Your email is required to move to the next step of the medical records process.";

    @FindBy(xpath = "(//div[@class='question-text'])[1]")
    WebElement titleText1;
    @FindBy(xpath = "(//div[@class='question-text'])[2]")
    WebElement titleText2;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> singleChoiceButtonsList;

    @Step
    public MedicalRecordsOptionPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText1, titleExpected1);
        waitForPageLoadMain(titleText2, titleExpected2);
        return this;
    }

    @Step
    public MedicalRecordsOptionPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(singleChoiceButtonsList, answerText);
        return this;
    }
}
