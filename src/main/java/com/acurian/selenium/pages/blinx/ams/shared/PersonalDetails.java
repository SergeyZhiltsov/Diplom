package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PersonalDetails extends MainPageBlinx {

    public final String titleExpected = "Personal details (*required fields)";
    public final String titleExpectedCaregiver = "Patient details (*required fields)";

    @FindBy(xpath = "//div[@id='QP1INF']//div[@class='question-text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@id='QI3']//div[@class='answers-container']//input")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='QI5']//div[@class='answers-container']//input")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@id='QI20']//div[@class='answers-container']//input")
    WebElement emailAddressField;

    @FindBy(xpath = "//div[@id='QI7']//div[@class='answers-container']//input")
    WebElement phoneField;

    @FindBy(xpath = "//div[@id='QI16']//div[@class='answers-container']//input")
    WebElement zipCodeField;

    @FindBy(xpath = "//div[@id='QI14']//div[@class='answers-container']//input")
    WebElement cityField;

    @FindBy(xpath = "//div[@id='QI15']//div[@class='answers-container']//select")
    WebElement stateDropdown;

    @Step
    public PersonalDetails waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PersonalDetails waitForPageLoadByTitle(String titleExpected) {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PersonalDetails setAllFields(String firstName, String lastName, String email, String phoneNumber, String zipCode, String city, String state) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        setPhone(phoneNumber);
        setZipCode(zipCode);
        waitForAnimation();
        setCity(city);
        setState(state);
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

    @Step
    public PersonalDetails setCity(String city) {
        typeTextWithoutClear(cityField, city);
        return this;
    }

    @Step
    public PersonalDetails setState(String state) {
        selectDropDownListOptionByText(stateDropdown, state);
        return this;
    }

}
