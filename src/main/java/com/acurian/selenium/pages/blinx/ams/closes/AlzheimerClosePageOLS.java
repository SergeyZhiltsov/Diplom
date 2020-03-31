package com.acurian.selenium.pages.blinx.ams.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlzheimerClosePageOLS extends MainPageBlinx {

    public final String titleExpected = "You could help prevent Alzheimer’s in future generations.\n" +
            "\n" +
            "At Synexus HealthyMinds Registry, our mission is to learn more about how healthy brains age. This crucial knowledge helps researchers explore potential methods of preventing and treating Alzheimer's and other types of dementia.\n" +
            "\n" +
            "And you can help these important research efforts by joining us! Participation is free, and as easy as completing some online questionnaires and tests once per year right from your home. They don’t take long to complete, and your information will be kept strictly confidential.\n" +
            "Plus, your brain will get some exercise. You’ll have access to brain-training games that stimulate memory and learning.\n" +
            "\n" +
            "To join, you must:\n" +
            "• Be 50 years of age or older\n" +
            "• Have access to the Internet\n" +
            "• Live in the United States\n" +
            "• NOT have Alzheimer’s or dementia";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public AlzheimerClosePageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
