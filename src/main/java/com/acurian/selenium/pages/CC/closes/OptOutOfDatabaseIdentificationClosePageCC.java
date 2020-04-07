package com.acurian.selenium.pages.CC.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class OptOutOfDatabaseIdentificationClosePageCC extends IdentificationOpeningOptionsClosePageCC {

    private final String titleExpected = "To ensure that we do not contact you again, please provide the following information:";

    @FindBy(xpath = "//input[contains(@class,'input-patient-email')]")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[contains(@class,'input-regular-phone')]")
    WebElement phoneField;

    @FindBy(xpath = "//input[contains(@class,'input-auto-zip')]")
    WebElement zipCodeField;

    public OptOutOfDatabaseIdentificationClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OptOutOfDatabaseIdentificationClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OptOutOfDatabaseIdentificationClosePageCC setAllFields(String firstName, String lastName, String email, String phoneNumber, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        return this;
    }

    @Step
    public OptOutOfDatabaseIdentificationClosePageCC setEmailAddress(String address) {
        typeText(emailAddressField, address);
        return this;
    }

    @Step
    public OptOutOfDatabaseIdentificationClosePageCC setPhone(String phoneNumber) {
        typeTextByActions(phoneField, phoneNumber);
        return this;
    }

    @Step
    public OptOutOfDatabaseIdentificationClosePageCC setZipCode(String zipCode) {
        typeText(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }
}
