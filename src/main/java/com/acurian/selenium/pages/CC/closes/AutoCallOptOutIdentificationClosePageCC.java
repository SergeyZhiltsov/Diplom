package com.acurian.selenium.pages.CC.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class AutoCallOptOutIdentificationClosePageCC extends IdentificationOpeningOptionsClosePageCC {

    public final String titleExpected = "We are sorry that you do not wish to continue receiving phone calls. " +
            "To ensure that we do not telephone you again, please provide the following information:";

    @FindBy(xpath = "//input[contains(@class,'input-patient-email')]")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[contains(@class,'input-regular-phone')]")
    WebElement phoneField;

    @FindBy(xpath = "//input[contains(@class,'input-evening-phone')]")
    WebElement eveningPhoneField;

    public AutoCallOptOutIdentificationClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AutoCallOptOutIdentificationClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AutoCallOptOutIdentificationClosePageCC setAllFields(String firstName, String lastName, String email, String phoneNumber, String eveningPhoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setEveningPhoneNumber(eveningPhoneNumber);
        return this;
    }

    @Step
    public AutoCallOptOutIdentificationClosePageCC setEmailAddress(String address) {
        typeText(emailAddressField, address);
        return this;
    }

    @Step
    public AutoCallOptOutIdentificationClosePageCC setPhone(String phoneNumber) {
        typeTextByActions(phoneField, phoneNumber);
        waitForAnimation();
        return this;
    }

    @Step
    public AutoCallOptOutIdentificationClosePageCC setEveningPhoneNumber(String eveningPhoneNumber) {
        typeTextByActions(eveningPhoneField, eveningPhoneNumber);
        waitForAnimation();
        return this;
    }
}
