package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FollowingImagesMostPageOLS extends MainPageOLS{

    public final String titleExpected = "We understand you do not feel you are currently in a Crohn’s flare. Please think about when you are in flare mode.\n" +
            "\n" +
            "Please indicate which of the following images most closely resembles your stool when you feel you are experiencing a Crohn’s flare.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public FollowingImagesMostPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingImagesMostPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingImagesMostPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
