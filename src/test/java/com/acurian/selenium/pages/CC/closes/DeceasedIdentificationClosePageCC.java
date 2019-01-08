package com.acurian.selenium.pages.CC.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DeceasedIdentificationClosePageCC extends IdentificationOpeningOptionsClosePageCC {
    public final String titleExpected = "We are sorry to hear that.  To ensure that we do not contact you again, please provide the following information:";

    @FindBy(xpath = "//input[contains(@class,'input-auto-zip')]")
    WebElement zipCodeField;

    public DeceasedIdentificationClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DeceasedIdentificationClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DeceasedIdentificationClosePageCC setAllFields(String firstName, String lastName, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
        return this;
    }

    @Step
    public DeceasedIdentificationClosePageCC setZipCode(String zipCode) {
        typeText(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }
}
