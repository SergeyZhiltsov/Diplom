package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class IdentificationPageCC extends MainPageCC {

    public final String titleExpected2 = "Good news! You have prequalified for a study. The next step is to select a doctor's office in your area so that they can contact you.\n" +
            "\n" +
            "Now, I just want to confirm that your name and contact information were entered correctly.\n" +
            "[Read the name, address and phone number to the caller. Make any corrections noted by the caller.]";

    public final String titleExpected = "Thank you for answering these questions. The next step is to match you with a study doctor in your area.\n" +
            "\n" +
            "Now, I just want to confirm that your name and contact information were entered correctly.\n" +
            "[Read the name, address and phone number to the caller. Make any corrections noted by the caller.]";

    public final String titleExpected1 = "After saying the language above, please abort screening.";

    public final String titleExpectedNotQ = "Personal details (*required fields)";

    public final String titleExpectedStandAloneQ = "Thank you! You have prequalified for the research study. The next " +
            "step is to select a doctor's office in your area so that they can contact you. They will probably ask " +
            "you some additional questions over the phone, and may invite you to come in to the office for an in-person " +
            "evaluation. Before you select a study doctor, please confirm that your name and contact information were entered correctly.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleTextGMEGA;

    @FindBy(xpath = "//div[@class='patient_block']/div[@class='question_text']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question_container']//div[@class='show-in-cc']/span[@class='agent-note']")
    WebElement titleTextt;

    @FindBy(xpath = "//*[@id='contact_info_form']/div[2]/div[1]")
    WebElement titleText3;

    @FindBy(xpath = "//input[contains(@class,'input-text-first-name')]")
    WebElement firstNameField;

    @FindBy(xpath = "//input[contains(@class,'input-text-last-name')]")
    WebElement lastNameField;

    @FindBy(xpath = "//input[contains(@class,'input-patient-email')]")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[contains(@class,'input-regular-phone')]")
    WebElement phoneField;

    @FindBy(xpath = "//input[contains(@class,'input-auto-zip')]")
    WebElement zipCodeField;

    public IdentificationPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public IdentificationPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoadStandAloneQ() {
        waitForPageLoadMain(titleText, titleExpectedStandAloneQ);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoadGMEGA() {
        waitForPageLoadMain(titleTextGMEGA, titleExpected2);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoad2() {
        waitForPageLoadMain(titleText, titleExpected2);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoad1() {
        waitForPageLoadMain(titleTextt, titleExpected1);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoadNotQ() {
        waitForPageLoadMain(titleText2, titleExpectedNotQ);
        return this;
    }

    @Step
    public IdentificationPageCC waitForPageLoadNotQCrohn() {
        waitForPageLoadMain(titleText3, titleExpectedNotQ);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

    @Step
    public String getEarlyCaptureTitleText() {
        return getText(titleText2);
    }

    @Step
    public IdentificationPageCC setAllFields(String firstName, String lastName, String email, String phoneNumber, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        return this;
    }

    @Step
    public IdentificationPageCC setFirstName(String name) {
        typeTextWithoutClear(firstNameField, name);
        return this;
    }

    @Step
    public IdentificationPageCC setLastName(String name) {
        typeTextWithoutClear(lastNameField, name);
        return this;
    }

    @Step
    public IdentificationPageCC setEmailAddress(String address) {
        typeTextWithoutClear(emailAddressField, address);
        return this;
    }

    @Step
    public IdentificationPageCC setPhone(String phoneNumber) {
        typeTextByActions(phoneField, phoneNumber);
//        typeText(phoneField, phoneNumber);
        return this;
    }

    @Step
    public IdentificationPageCC setZipCode(String zipCode) {
        typeTextWithoutClear(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }

}
