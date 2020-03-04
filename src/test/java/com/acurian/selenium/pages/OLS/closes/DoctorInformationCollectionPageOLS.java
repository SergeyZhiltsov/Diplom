package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageOLS extends MainPageOLS{

    public final String titleExpected = "We're almost done with this questionnaire!\n" +
            "\n" +
            "Please enter contact information for the doctors who are treating or who have treated your condition. We will contact your doctor(s) to request your medical records and send them to the study doctor. The information you provide now will help speed up your first appointment at the study doctor’s office.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the study doctor's office, except as required by law.";

    public final String titleExpectedIBDcommon = "We're almost done with this questionnaire!\n" +
            "\n" +
            "Your medical records related to your %1$s history are required. To make this process easier, our no cost service will obtain these records for you.\n" +
            "\n" +
            "Please enter contact information for ALL doctors who treat your %1$s, as well as your primary care physician. Your medical records from these doctors are critical.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the study doctor's office, except as required by law.";

    public final String titleGmegaExpected = "We now need some information on the doctors who are treating or who have treated your condition.\n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    public final String titleGmegaQAExpected = "We now need some information on the doctors who are treating or who have treated your condition.  \n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleTextGMEGA;

    public DoctorInformationCollectionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoadGmega() {
        waitForPageLoadMain(titleText, titleGmegaExpected);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoadByTitle(String title) {
        waitForPageLoadMain(titleText, title);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoadByTitleGMEGA(String title) {
        waitForPageLoadMain(titleTextGMEGA, title);
        return this;
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoadIBD(String siteIndication) {
        String titleExpectedMod = String.format(titleExpectedIBDcommon, siteIndication);
        waitForPageLoadMain(titleText, titleExpectedMod);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
