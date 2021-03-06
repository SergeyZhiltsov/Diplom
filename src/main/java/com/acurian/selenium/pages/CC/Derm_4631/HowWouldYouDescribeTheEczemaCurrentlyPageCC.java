package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HowWouldYouDescribeTheEczemaCurrentlyPageCC extends MainPageCC {

    public final String titleExpected = "How would you describe the eczema currently on your body?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HowWouldYouDescribeTheEczemaCurrentlyPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouDescribeTheEczemaCurrentlyPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouDescribeTheEczemaCurrentlyPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}