package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.CC.generalHealth.IdentificationPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class IdentificationPageOLS extends MainPageOLS{

    public final String titleExpected = "Congratulations, you have prequalified!\n" +
            "\n" +
            "Enrollment is limited. Please complete the following information so that we may match you with a study doctor.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
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
    }

    @Step
    public IdentificationPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
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
