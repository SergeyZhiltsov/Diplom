package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class QualifiedClose2PageOLS extends MainPageOLS{

    //Qualified Close 2: No Pediatric Study Switch - 35
    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    public final String titleExpected_SB = "We're glad the location is convenient for you. We will forward your contact information to the doctor's office that you selected so they may contact you.\n" +
            "\n" +
            "To ensure that you are a good candidate for the study, the research physician will need to review your medical records related to your RA history. In order to make this process easier for you, we have a free service that can obtain these records on your behalf.\n" +
            "\n" +
            "Within the next few days you will receive an orange envelope from us that will include information about the next steps and a medical record release form. In order for us to obtain your records for you, simply fill out, sign, and return the form in the envelope provided. Your records will then be sent directly to the research study physician.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";


    public final String titleExpectedIBD4818 ="We’re glad the location is convenient for you.\n" +
            "\n" +
            "We will forward your contact information to the doctor’s office that you selected so they may contact you about a Crohn's Disease, Ulcerative Colitis study.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    public QualifiedClose2PageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoad_SB() {
        waitForPageLoadMain(titleText, titleExpected_SB);
        return this;
    }

    @Step
    public QualifiedClose2PageOLS waitForPageLoadIBD4818() {
        waitForPageLoadMain(titleText, titleExpectedIBD4818);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
