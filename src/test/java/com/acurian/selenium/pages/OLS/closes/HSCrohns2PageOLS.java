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

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
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
    public String getTitleText(){
        return getText(titleText);
    }
}
