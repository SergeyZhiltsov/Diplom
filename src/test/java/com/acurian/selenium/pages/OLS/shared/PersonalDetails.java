package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonalDetails extends MainPageOLS {

    public final String titleExpected = "Personal details (*required fields)";
    public final String titleExpectedCaregiver = "Patient details (*required fields)";

    @FindBy(xpath = "//h2[@id='patient-title']")
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

    @Step
    public PersonalDetails waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PersonalDetails waitForPageLoadByTitle(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PersonalDetails setAllFields(String firstName, String lastName, String email, String phoneNumber, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        waitForAnimation();
        return this;
    }

    @Step
    public PersonalDetails setFirstName(String name) {
        typeTextWithoutClear(firstNameField, name);
        waitForAnimation();
        return this;
    }

    @Step
    public PersonalDetails setLastName(String name) {
        typeTextWithoutClear(lastNameField, name);
        waitForAnimation();
        return this;
    }

    @Step
    public PersonalDetails setEmailAddress(String address) {
        typeTextWithoutClear(emailAddressField, address);
        waitForAnimation();
        return this;
    }

    @Step
    public PersonalDetails setPhone(String phoneNumber) {
        typeTextWithoutClear(phoneField, phoneNumber);
        waitForAnimation();
        return this;
    }

    @Step
    public PersonalDetails setZipCode(String zipCode) {
        typeTextWithoutClear(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }
}
