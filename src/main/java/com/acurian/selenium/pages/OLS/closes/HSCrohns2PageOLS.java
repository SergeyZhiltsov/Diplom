package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSCrohns2PageOLS extends MainPageOLS{

    //3485
    public final String titleExpected = "Your medical records related to your Crohn's Disease history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "On the next page, please provide the contact information of both the specialist who treats you for your Crohn's Disease, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.";

    public final String titleExpectedGBAN = "Your medical records related to your Alzheimer's Risk history are required for the study doctor to evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
            "\n" +
            "Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
            "\n" +
            "You will need to provide us with some information on the doctors who are treating or have treated your condition. We will then email you a link where you can verify your information and e-sign a release form so that we can obtain your records.";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    public HSCrohns2PageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSCrohns2PageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HSCrohns2PageOLS waitForPageLoadGBAN() {
        waitForPageLoadMain(titleText, titleExpectedGBAN);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
