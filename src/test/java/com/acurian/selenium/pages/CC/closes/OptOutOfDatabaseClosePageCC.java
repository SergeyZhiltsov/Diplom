package com.acurian.selenium.pages.CC.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OptOutOfDatabaseClosePageCC extends MainPageCC {

    public final String titleExpected = "We are sorry that you do not wish to remain in Acurian's database. We want to make sure you know that your " +
            "privacy has not been compromised in any way, and that we did not receive your information from your doctor or any other health professional. " +
            "Acurian sends information to people who we believe may be interested in research study opportunities. You may have previously expressed interest " +
            "in receiving information about this health condition through a survey or on Acurian's website, or you may have been included in our mailing because " +
            "of generally available demographic information about you, like your age and gender.\n" +
            "\n" +
            "Agent Note: Optional language for CC agents if additional follow-up is necessary: Acurian receives information from companies who conduct surveys which " +
            "include health-related information. It is possible that you filled out one of these surveys at some time in the past, even several years ago, and provided " +
            "permission to be contacted with information about the health concerns that you reported at that time. It is also possible that you never filled out a survey of " +
            "this type. Since some medical conditions are more common among certain age groups, you may have been included in a mailing because you live near one of the research " +
            "centers, and people of your age group and/or gender are more likely to have the condition that is being researched. I would like to assure you again that we have not " +
            "received any health information about you from your doctor, insurance company, or any other medical professional. If you are concerned about your privacy I can submit a " +
            "request for someone from Acurian to follow up and let you know exactly where we received your name.\n" +
            "\n" +
            "Would you like to be removed from our database at this time?";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OptOutOfDatabaseClosePageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OptOutOfDatabaseClosePageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OptOutOfDatabaseClosePageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
