package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChatfillMedicalRecordReleaseFormPageOLS extends MainPageOLS {
    final String titleTextExpected = "Medical Record Release Form";

    @FindBy(css = "p.med-rec-release")
    WebElement titleText;
    @FindBy(css = "#altPatientConfirm span[class='checkmark']")
    WebElement confirmPatientInformationCheckbox;
    @FindBy(id = "continueBtn")
    WebElement signForm;
    @FindBy(id = "doctor1Name")
    WebElement doctorNameField;
    @FindBy(id = "doctor1State")
    WebElement selectDoctorStateList;
    @FindBy(id = "doctor1Number")
    WebElement doctorTelephoneNumber;
    @FindBy(id = "doctor1Address")
    WebElement doctorAddress;
    @FindBy(id = "doctor1City")
    WebElement selectDoctorCityList;
    @FindBy(id = "doctor1Zip")
    WebElement doctorZip;

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS waitForPageLoad() {
        try {
            acceptAlert();
        } catch (Exception ex) {
            logTextToAllure("Alert was not appeared. Retry in 10 seconds");
            threadSleep(10000);
            acceptAlert();
        }
        getDriver().switchTo().frame("chartfill-iframe");
        waitForAnimation();
        waitForPageLoadMain(titleText, titleTextExpected);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS confirmPatientInformation() {
        waitAndClickWebElement(confirmPatientInformationCheckbox);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS typeDoctorName(String doctorName) {
        waitForVisibility(doctorNameField);
        typeTextWithoutClear(doctorNameField, doctorName);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS selectState(String state) {
        waitForVisibility(selectDoctorStateList);
        selectDropDownListOptionByText(selectDoctorStateList, state);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS selectCity(String city) {
        waitForVisibility(selectDoctorCityList);
        selectDropDownListOptionByText(selectDoctorCityList, city);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS typeTelephone(String phoneNumber) {
        waitForVisibility(doctorTelephoneNumber);
        typeTextWithoutClear(doctorTelephoneNumber, phoneNumber);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS typeDoctorAddress(String address) {
        waitForVisibility(doctorAddress);
        typeTextWithoutClear(doctorAddress, address);
        return this;
    }

    @Step
    ChatfillMedicalRecordReleaseFormPageOLS typeDoctorZip(String zip) {
        waitForVisibility(doctorZip);
        typeTextWithoutClear(doctorZip, zip);
        return this;
    }

    @Step
    public <T extends MainPageOLS> T clickSignForm(T page) {
        signForm.click();
        return (T) page;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLS setAllDataMedicalRecordReleaseForm(String doctorName, String state,
                                                                                      String phoneNumber, String address, String city, String zip) {
        typeDoctorName(doctorName);
        selectState(state);
        typeTelephone(phoneNumber);
        typeDoctorAddress(address);
        selectCity(city);
        typeDoctorZip(zip);
        return this;
    }

    @Step()
    private WebElement waitAndClickWebElement(WebElement element) {
        driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    @Step()
    private WebElement waitForVisibility(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.visibilityOf(element));
    }
}