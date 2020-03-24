package com.acurian.selenium.pages.CC.common_elements;

import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPatientPage extends MainPageCC {
    final String expectedTitleText = "Welcome to Find Patient. Please enter criteria to find and rescreen a patient.\n" +
            "If you know the Patient ID, that's all you have to enter to find the patient.\n" +
            "If you know the Call ID, that's all you have to enter to find the patient.\n" +
            "If you don't know the Patient ID or Call ID, you must enter a Call Date with Patient Information to narrow down search results. Up to 100 records will be provided in search results.";

    @FindBy(xpath = "//div[@id='content']/div")
    WebElement titleText;

    public FindPatientPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FindPatientPage waitForPageLoad() {
        waitForPageLoadMain(titleText, expectedTitleText);
        return this;
    }
}
