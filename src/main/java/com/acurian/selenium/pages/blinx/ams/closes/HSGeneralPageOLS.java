package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSGeneralPageOLS extends MainPageBlinx {

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "\n" +
            "Next Steps:\n" +
            "On the next screen, please provide information about the doctors who are currently treating, or have previously treated, your %s.\n" +
            "You will need to complete the medical authorization form, then you will be asked to connect your health data.\n" +
            "\n" +
            "This information will be sent to the study site to allow them to evaluate you for the research study.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleExpected1 = "We're glad the location is convenient for you.\n" +
            "\n" +
            "Next Steps:\n" +
            "On the next screen, please provide information about the doctors who are currently treating, or have previously treated, your Type 2 Diabetes and related health conditions.\n" +
            "You will need to complete the medical authorization form, then you will be asked to connect your health data.\n" +
            "\n" +
            "This information will be sent to the study site to allow them to evaluate you for the research study.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleExpectedNoPIIemail = "We’re almost done with this questionnaire!\n\n" +
            "As the next step, please enter your email address. We will keep it confidential. Your email is required to move to the next step of the study pre-screening process.";

    public final String titleRaExpectedSTG = "Your medical records related to your Rheumatoid Arthritis, Diabetes, Low Back Pain, Arthritis history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleRaExpectedNew = "Your medical records related to your Low Back Pain, Arthritis, Diabetes, Rheumatoid Arthritis history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleRaExpectedNew2 = "Your medical records related to your Low Back Pain, Arthritis, Rheumatoid Arthritis, Diabetes history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleExpectedCut = "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleRaExpectedSTGGMEGA3 = "Your medical records related to your Diabetes, Low Back Pain, Arthritis, Rheumatoid Arthritis history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition.  We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleRaExpectedQA =  "Your medical records related to your Low Back Pain, Diabetes, Arthritis, Rheumatoid Arthritis history are required for the study doctor to evaluate you for participation.  In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.";

    public final String titleRa1Expected = "Your medical records related to your Low Back Pain, Diabetes, Arthritis, " +
            "Rheumatoid Arthritis history are required for the study doctor to evaluate you for participation. " +
            "In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleExpected4556 = "We're glad the location is convenient for you.\n" +
            "\n" +
            "Next Steps:\n" +
            "On the next screen, please provide information about the doctors who manage your routine care, including vaccinations.\n" +
            "You will need to complete the medical authorization form, then you will be asked to connect your health data.\n" +
            "\n" +
            "This information will be sent to the study site to allow them to evaluate you for the research study.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGMEGA;

    @FindBy(xpath = "//div[@id='questions']//div[@class='show-in-ols']")
    WebElement titleTextNew;


    @FindBy(xpath = "//input[@type='email']")
    WebElement emailBox;

    public HSGeneralPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSGeneralPageOLS waitForPageLoad() {
        waitForAnimation();
//        String titleExpectedMod = String.format(titleExpected, siteIndication);
        waitForPageLoadMain(titleText, titleRaExpectedQA);
        return this;
    }
    @Step
    public HSGeneralPageOLS waitForPageLoadNew() {
        waitForAnimation();
//        String titleExpectedMod = String.format(titleExpected, siteIndication);
        waitForPageLoadMain(titleText, titleRaExpectedNew);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadNew2() {
        waitForAnimation();
//        String titleExpectedMod = String.format(titleExpected, siteIndication);
        waitForPageLoadMain(titleText, titleRaExpectedNew2);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadCut() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedCut);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadEmailNotProvided() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpectedNoPIIemail);
        return this;
    }


    @Step
    public HSGeneralPageOLS waitForPageLoadT2DM() {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected1);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadByTitle(String titleExpected) {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HSGeneralPageOLS waitForPageLoadByTitleGMEGA(String titleExpected) {
        waitForAnimation();
        waitForPageLoadMain(titleTextGMEGA, titleExpected);
        return this;
    }
    @Step
    public HSGeneralPageOLS waitForPageLoadByTitleNew(String titleExpected) {
        waitForAnimation();
        waitForPageLoadMain(titleTextNew, titleExpected);
        return this;
    }

    @Step
    public HSGeneralPageOLS typeEmail(String text) {
        typeText(emailBox, text);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
