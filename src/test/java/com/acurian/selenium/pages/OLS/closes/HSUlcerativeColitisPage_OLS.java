package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class HSUlcerativeColitisPage_OLS extends MainPageOLS{

    //3638UC and 3638C
    public final String titleExpected = "Your medical records related to your Ulcerative Colitis history are required for the study doctor to effectively evaluate you for participation. In order to help make this process easier for you, we have a free service that will obtain these records on your behalf.\n" +
    		"\n" +
    		"On the next page, please provide the contact information of both the specialist who treats you for your Ulcerative Colitis, your gastroenterologist (GI), as well as your primary care physician or general practitioner (GP). Your medical records from both doctors are critical since they are more detailed and provide information on your diagnosis, all of your medications, and the imaging/ scoping that may have been done for your digestive condition.\n" +
    		"\n" +
    		"Please be assured that your records will be kept confidential and only shared with the research facility.\n" +
    		"\n" +
    		"You will need to provide us with an email address to start this process. Please enter your email address below:";

    
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;
    
    @FindBy(xpath = "//input[contains(@id,'QSC9092')]")
    WebElement email;
    
    @Step
    public HSUlcerativeColitisPage_OLS setEmailID(String name) {
        typeTextWithoutClear(email, name);
        return this;
    }

    public HSUlcerativeColitisPage_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HSUlcerativeColitisPage_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
