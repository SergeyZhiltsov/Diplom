package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class QualifiedClose2PageCC extends MainPageCC {

    //Qualified Close 2: No Pediatric Study Switch - 35_number

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they can contact you.";

    public final String titleExpected2 = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    public final String titleExpectedGMEGA = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you about your condition Low Back Pain, Arthritis, Rheumatoid Arthritis, Diabetes";

    public final String titleExpectedIBD = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they may contact you about a Ulcerative Colitis study.";

    public final String titleExpectedUC4818 = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Ulcerative Colitis study.";

    public final String titleExpectedIBD4818Stag = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Crohn's Disease, Ulcerative Colitis study.";

    public final String titleExpectedIBD4818Prod = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Ulcerative Colitis, Crohn's Disease study.";

    public final String titleExpectedCrohns= "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they may contact you about a Crohn's Disease, Ulcerative Colitis study.";

    public final String titleExpected_SB = "We're glad the location is convenient for you. We will forward your contact information to the doctor's office that you selected so they may contact you.\n" +
            "\n" +
            "To ensure that you are a good candidate for the study, the research physician will need to review your medical records related to your RA history. In order to make this process easier for you, we have a free service that can obtain these records on your behalf.\n" +
            "\n" +
            "Within the next few days you will receive an orange envelope from us that will include information about the next steps and a medical record release form. In order for us to obtain your records for you, simply fill out, sign, and return the form in the envelope provided. Your records will then be sent directly to the research study physician.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    String env = System.getProperty("acurian.env", "STG");

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public QualifiedClose2PageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    @Step
    public QualifiedClose2PageCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadGMEGA() {
        waitForPageLoadMain(titleText, titleExpectedGMEGA);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadCrohns() {
        waitForPageLoadMain(titleText, titleExpectedCrohns);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadCrohns4818() {
        waitForPageLoadMain(titleText, titleExpectedUC4818);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadUC4818() {
        waitForPageLoadMain(titleText, titleExpectedUC4818);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadIBD() {
        waitForPageLoadMain(titleText, titleExpectedIBD);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoad_SB() {
        waitForPageLoadMain(titleText, titleExpected_SB);
        return this;
    }

    @Step
    public QualifiedClose2PageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public QualifiedClose2PageCC waitForPageLoadIBD4818() {
        String titleExpectedIBD4818 = env.equals("STG") ? titleExpectedIBD4818Stag : titleExpectedIBD4818Prod;
        waitForPageLoadMain(titleText, titleExpectedIBD4818);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
