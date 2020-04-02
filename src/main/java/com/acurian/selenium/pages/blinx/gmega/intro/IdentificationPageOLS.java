package com.acurian.selenium.pages.blinx.gmega.intro;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IdentificationPageOLS extends MainPageBlinx {

    /*private final String titleExpectedPart1 = "Congratulations, you have prequalified!\n\n" +
            "Enrollment is limited. Please complete the following information so that we may match you with a study doctor."; */

    private final String titleExpectedPart1 = "Thank you for answering these questions.\n" +
            "\n" +
            "Please complete the following information so that we can match you with a study doctor in your area.";

    public final String titleExpected_GMEGA = "Congratulations, you have prequalified!\n" +
            "\n" +
            "Enrollment is limited. Please complete the following information so that we may match you with a study doctor.";

    private final String titleExpectedPart2 = "Personal details (*required fields)";
    private final String titleExpectedPart3 = "Your privacy is important to us. By clicking \"Next,\" you agree to our Privacy Policy and Terms of Use, and agree that we may share your information with personnel involved in conducting the study and we or our affiliates may contact you by phone using automated technology or pre-recorded voicemail or other means regarding research studies.";
    private final String titleExpectedPart4 = "Your privacy is important to us. By clicking \"Next,\" you agree to our Privacy Policy and Terms of Use, and agree that we may share your information with personnel involved in conducting the study, or otherwise as described in the Acurian Privacy Policy, and we or our affiliates may contact you by phone using automated technology or pre-recorded voicemail or other means regarding research studies.";
    private final String titleExpectedPart4STG = "Your privacy is important to us. By clicking \"Next,\" you agree to our Privacy Policy and Terms of Use, and agree that we may share your information with personnel involved in conducting the study and may contact you by phone using automated technology or pre-recorded voicemail or other means regarding research studies.";

    private final String titleExpectedNew ="Your privacy is important to us. By clicking \"Next,\" you agree to our Privacy Policy and Terms of Use, and agree that we may share your information with personnel involved in conducting the study and may contact you by phone using automated technology or pre-recorded voicemail or other means regarding research studies.";
    @FindBy(xpath = "(//div[@class='question-text'])[1]")
    WebElement titleTextPart1;
    @FindBy(xpath = "(//div[@class='question-text'])[2]")
    WebElement titleTextPart2;
    @FindBy(xpath = "(//div[@class='question-text'])[13]")
    WebElement titleTextPart4;
    @FindBy(xpath = "//div[@data-question-basis='FIRST_NAME']//input")
    WebElement firstNameField;
    @FindBy(xpath = "//div[@data-question-basis='LAST_NAME']//input")
    WebElement lastNameField;
    @FindBy(xpath = "//div[@data-question-basis='EMAIL']//input")
    WebElement emailAddressField;
    @FindBy(xpath = "//div[@data-question-basis='DAY_PHONE']//input")
    WebElement phoneField;
    @FindBy(xpath = "//div[@data-question-basis='ZIP']//input")
    WebElement zipCodeField;
    @FindBy(xpath = "//div[@data-question-basis='CITY']//input")
    WebElement cityField;
    @FindBy(xpath = "//div[@data-question-basis='STATE']//select")
    WebElement stateDropdown;
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public IdentificationPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        waitForPageLoadMain(titleTextPart4, titleExpectedPart3);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadNew() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        waitForPageLoadMain(titleTextPart4, titleExpectedNew);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoad2() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        waitForPageLoadMain(titleTextPart4, titleExpectedPart4);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadGMEGA() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected_GMEGA);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadSTG() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        waitForPageLoadMain(titleTextPart4, titleExpectedPart4STG);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadPrequalified() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart1, titleExpectedPart1);
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        waitForPageLoadMain(titleTextPart4, titleExpectedPart4);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadNotQ() {
        waitForAnimation();
        waitForPageLoadMain(titleTextPart2, titleExpectedPart2);
        return this;
    }

    //Method without zipcode
    @Step
    public IdentificationPageOLS setAllFields(String firstName, String lastName, String email, String phoneNumber/*,
                                              String zipCode*/) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        //setZipCode(zipCode);
        waitForAnimation();
        return this;
    }

    //Method with zipcode
    @Step
    public IdentificationPageOLS setAllFields(String firstName, String lastName, String email, String phoneNumber,
                                              String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        threadSleep(1);
        waitForAnimation();
        return this;
    }

    @Step
    public IdentificationPageOLS setFirstName(String firstName) {
        typeTextWithoutClear(firstNameField, firstName);
        return this;
    }

    @Step
    public IdentificationPageOLS setLastName(String lastName) {
        typeTextWithoutClear(lastNameField, lastName);
        return this;
    }

    @Step
    public IdentificationPageOLS setEmailAddress(String email) {
        typeTextWithoutClear(emailAddressField, email);
        return this;
    }

    @Step
    public IdentificationPageOLS setPhone(String phoneNumber) {
        typeTextWithoutClear(phoneField, phoneNumber);
        return this;
    }

    @Step
    public IdentificationPageOLS setZipCode(String zipCode) {
        typeTextWithoutClearAndConfirm(zipCodeField, zipCode);
        return this;
    }

    @Step
    public IdentificationPageOLS setCity(String city) {
        typeTextWithoutClear(cityField, city);
        return this;
    }

    @Step
    public IdentificationPageOLS setState(String state) {
        selectDropDownListOptionByText(stateDropdown, state);
        return this;
    }
}
