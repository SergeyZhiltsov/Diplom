package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClose2PageOLS extends MainPageOLS {

    //Qualified Close 2: No Pediatric Study Switch - 35
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor's office that you selected so they can contact you.";

//    public final String titleExpectedGMEGA = "We're glad the location is convenient for you. \n" +
//            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    public final String titleExpectedGMEGA = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you about your condition Low Back Pain, Arthritis, Rheumatoid Arthritis, Diabetes";

    public final String titleExpectedGMEGA2 = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you about your condition Low Back Pain, Arthritis, Rheumatoid Arthritis, Diabetes";

    public final String titleExpected_SB = "We're glad the location is convenient for you. We will forward your contact information to the doctor's office that you selected so they may contact you.\n" +
            "\n" +
            "To ensure that you are a good candidate for the study, the research physician will need to review your medical records related to your RA history. In order to make this process easier for you, we have a free service that can obtain these records on your behalf.\n" +
            "\n" +
            "Within the next few days you will receive an orange envelope from us that will include information about the next steps and a medical record release form. In order for us to obtain your records for you, simply fill out, sign, and return the form in the envelope provided. Your records will then be sent directly to the research study physician.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";


    public final String titleExpectedIBD4818Stag = "WWe’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Ulcerative Colitis, Crohn's Disease study.";

    public final String titleExpectedCrohns4818 = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Crohn's Disease study.";

    public final String titleExpectedIBD4818Prod = "We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they can contact you about a Ulcerative Colitis, Crohn's Disease study.";

    String env = System.getProperty("acurian.env", "STG");

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;


    @Step
    public QualifiedClose2PageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoadCrohns4818() {
        waitForPageLoadMain(titleText, titleExpectedCrohns4818);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoadGMEGA() {
        waitForPageLoadMain(titleText, titleExpectedGMEGA);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoadGMEGA2() {
        waitForPageLoadMain(titleText, titleExpectedGMEGA2);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoad_SB() {
        waitForPageLoadMain(titleText, titleExpected_SB);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoadIBD4818() {
        String titleExpectedIBD4818 = env.equals("STG") ? titleExpectedIBD4818Stag : titleExpectedIBD4818Prod;
        waitForPageLoadMain(titleText, titleExpectedIBD4818);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
