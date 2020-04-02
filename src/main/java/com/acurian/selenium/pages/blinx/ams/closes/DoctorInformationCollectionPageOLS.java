package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageOLS extends MainPageBlinx {

    public final String titleExpected = "We now need some information on the doctors who are treating or who have treated your condition.  \n" +
            "We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records. ";

    public final String titleExpectedIBDcommon = "We're almost done with this questionnaire!\n" +
            "\n" +
            "Your medical records related to your %1$s history are required. To make this process easier, our no cost service will obtain these records for you.\n" +
            "\n" +
            "Please enter contact information for ALL doctors who treat your %1$s, as well as your primary care physician. Your medical records from these doctors are critical.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the study doctor's office, except as required by law.";

    @FindBy(xpath = "(//div[@class='question-text'])[1]")
    WebElement titleText;

    public DoctorInformationCollectionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
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
