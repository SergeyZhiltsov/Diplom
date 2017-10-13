package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class IdentificationPageCC extends MainPageCC {

    public final String titleExpected = "Good news! You have prequalified for a study. The next step is to select a doctor's office in your area so that they can contact you.\n" +
            "\n" +
            "Now, I just want to confirm that your name and contact information were entered correctly.\n" +
            "[Read the name, address and phone number to the caller. Make any corrections noted by the caller.]";
    
    public final String titleExpected1 = "After saying the language above, please abort screening.";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='question_container']//div[@class='show-in-cc']/span[@class='agent-note']")
    WebElement titleTextt;

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
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }
    
    @Step
    public IdentificationPageCC waitForPageLoad1() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleTextt.getText().contains(titleExpected1));
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
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
        typeTextWithoutClear(phoneField, phoneNumber);
        return this;
    }

    @Step
    public IdentificationPageCC setZipCode(String zipCode) {
        typeTextWithoutClear(zipCodeField, zipCode);
        waitForAnimation();
        return this;
    }
}
