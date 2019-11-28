package com.acurian.selenium.pages.blinx.ams;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChatfillMedicalRecordReleaseFormPageOLSBlinx extends MainPageBlinx {

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
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx waitForPageLoad() {
        try {
            acceptAlert();
        } catch (Exception ex) {
            logTextToAllureAndConsole("Alert was not appeared. Retry in 10 seconds");
            threadSleep(10000);
            try {
                acceptAlert();
            } catch (Exception exeption) {
                logTextToAllureAndConsole("Alert was not appeared.");
            }

        }
        getDriver().switchTo().frame("chartfill-iframe");
        waitForAnimation();
        waitForPageLoadMain(titleText, titleTextExpected);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx confirmPatientInformation() {
        waitAndClickWebElement(confirmPatientInformationCheckbox);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx typeDoctorName(String doctorName) {
        waitForVisibility(doctorNameField);
        typeTextWithoutClear(doctorNameField, doctorName);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx selectState(String state) {
        waitForVisibility(selectDoctorStateList);
        selectDropDownListOptionByText(selectDoctorStateList, state);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx selectCity(String city) {
        waitForVisibility(selectDoctorCityList);
        selectDropDownListOptionByText(selectDoctorCityList, city);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx typeTelephone(String phoneNumber) {
        waitForVisibility(doctorTelephoneNumber);
        typeTextWithoutClear(doctorTelephoneNumber, phoneNumber);
        return this;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx typeDoctorAddress(String address) {
        waitForVisibility(doctorAddress);
        typeTextWithoutClear(doctorAddress, address);
        return this;
    }

    @Step
    ChatfillMedicalRecordReleaseFormPageOLSBlinx typeDoctorZip(String zip) {
        waitForVisibility(doctorZip);
        typeTextWithoutClear(doctorZip, zip);
        return this;
    }

    @Step
    public <T extends MainPageBlinx> T clickSignForm(T page) {
        signForm.click();
        return (T) page;
    }

    @Step
    public ChatfillMedicalRecordReleaseFormPageOLSBlinx setAllDataMedicalRecordReleaseForm(String doctorName, String state,
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
    protected WebElement waitAndClickWebElement(WebElement element) {
        driverWait.getWaitDriver().until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    @Step()
    private WebElement waitForVisibility(WebElement element) {
        return driverWait.getWaitDriver().until(ExpectedConditions.visibilityOf(element));
    }

}
