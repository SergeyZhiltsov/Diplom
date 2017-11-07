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

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public HSMedicalRecordsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSMedicalRecordsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
