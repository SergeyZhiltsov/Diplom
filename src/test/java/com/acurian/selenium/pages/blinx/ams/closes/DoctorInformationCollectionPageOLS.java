package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class DoctorInformationCollectionPageOLS extends MainPageBlinx {

    public final String titleExpected = "We're almost done with this questionnaire!\n" +
            "\n" +
            "Please enter contact information for the doctors who are treating or who have treated your condition. We will contact your doctor(s) to request your medical records and send them to the study doctor. The information you provide now will help speed up your first appointment at the study doctor’s office.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the study doctor's office, except as required by law.";

    @FindBy(xpath = "//div[@id='questions']/div[1]//div[@class='show-in-ols']")
    WebElement titleText;

    public DoctorInformationCollectionPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoctorInformationCollectionPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }


}
