package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageCC extends MainPageCC{

    public final String titleExpected = "We're almost done with this questionnaire!\n" +
            "\n" +
            "Please provide contact information for the doctors who are treating or who have treated your condition. We will contact your doctor(s) to request your medical records and send them to the study doctor. The information you provide now will help speed up your first appointment at the study doctor’s office.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the study doctor's office.";

    public final String titleExpectedGmega = "We now need some information on the doctors who are treating or who have treated your condition.  \n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    public DoctorInformationCollectionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageCC waitForPageLoadGmega() {
        waitForPageLoadMain(titleText, titleExpectedGmega);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
