package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSMedicalRecordsPageCC extends MainPageCC{

    //Hello Sign Medical Records - E-Signature Question - 27
    public final String titleExpected = "Thank you for providing this information. You will receive an email from us shortly. Please verify the information and provide your e-signature as soon as you receive this email.\n" +
            "Agent Note: Do not wait to confirm receipt of email. Click \"next\" to continue.";

    public final String titleExpectedGmega = "Thank you for providing this information.\n" +
            "You will receive an email from us shortly.\n" +
            "Please verify the information and provide your e-signature as soon as you receive this email.\n" +
            "Agent Note: Do not wait for patient to retrieve email. Move to next screen.";

    public final String titleExpectedGmegaSTG = "Thank you for providing this information.\n" +
            "You will receive an email from us shortly.\n" +
            "Please verify the information and provide your e-signature as soon as you receive this email.\n" +
            "Agent Note: Do not wait for patient to retrieve email. Move to next screen.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleTextGmega;

    public HSMedicalRecordsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSMedicalRecordsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HSMedicalRecordsPageCC waitForPageLoadGmega() {
        waitForPageLoadMain(titleTextGmega, titleExpectedGmega);
        return this;
    }

    @Step
    public HSMedicalRecordsPageCC waitForPageLoadByTitle(String title) {
        waitForPageLoadMain(titleText, title);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
