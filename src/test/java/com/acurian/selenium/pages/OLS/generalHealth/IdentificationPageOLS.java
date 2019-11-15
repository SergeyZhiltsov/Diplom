package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.constants.Platforms;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class IdentificationPageOLS extends MainPageOLS{

    public final String titleExpected = "Thank you for answering these questions.\n" +
            "\n" +
            "Please complete the following information so that we can match you with a study doctor in your area.";

    public final String titleExpectedNotQ = "Personal details (*required fields)";
    public final String titleExpectedCaregiver = "Patient details (*required fields)";

    public final String titleExpected_SB = "Congratulations, you have prequalified for the study!  \n" +
            "Enrollment is limited. Please confirm your contact information below to reserve your space.";

    @FindBy(xpath = "//h2[@id='patient-title']")
    WebElement titleTextNotQ;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText1;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-sm-block')]/div[@class='show-in-ols']")
    WebElement titleText2;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-xs-block')]/div[@class='show-in-ols']")
    WebElement titleText3;

    WebElement titleText;

    @FindBy(xpath = "//input[@id='QI3']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='QI5']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='QI20']")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='QI7']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@id='QI16']")
    WebElement zipCodeField;

    public IdentificationPageOLS() {
        PageFactory.initElements(getDriver(), this);
        switch (Locators.isEnvWeb) {
            case Platforms.WEB:
                titleText = titleText1;
                break;
            case Platforms.TABLET:
                titleText = titleText2;
                break;
            case Platforms.MOBILE:
                titleText = titleText3;
                break;
        }
    }

    @Step
    public IdentificationPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadSB() {
        waitForPageLoadMain(titleText, titleExpected_SB);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadNotQ() {
        waitForPageLoadMain(titleTextNotQ, titleExpectedNotQ);
        return this;
    }

    @Step
    public IdentificationPageOLS waitForPageLoadCaregiver () {
        waitForPageLoadMain(titleTextNotQ, titleExpectedCaregiver);
        return this;
    }

    @Step
    public IdentificationPageOLS setAllFields(String firstName, String lastName, String email, String phoneNumber, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        waitForAnimation();
        return this;
    }

    @Step
    public IdentificationPageOLS setFirstName(String name) {
        typeTextWithoutClear(firstNameField, name);
        waitForAnimation();
        return this;
    }

    @Step
    public IdentificationPageOLS setLastName(String name) {
        typeTextWithoutClear(lastNameField, name);
        waitForAnimation();
        return this;
    }

    @Step
    public String getFirstName() {
        return getText(firstNameField);
    }

    @Step
    public String getLastName() {
        return getText(lastNameField);
    }

    @Step
    public IdentificationPageOLS setEmailAddress(String address) {
        typeTextWithoutClear(emailAddressField, address);
        waitForAnimation();
        return this;
    }

    @Step
    public IdentificationPageOLS setPhone(String phoneNumber) {
        typeTextWithoutClear(phoneField, phoneNumber);
        waitForAnimation();
        return this;
    }

    @Step
    public IdentificationPageOLS setZipCode(String zipCode) {
        typeTextWithoutClear(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }


}
