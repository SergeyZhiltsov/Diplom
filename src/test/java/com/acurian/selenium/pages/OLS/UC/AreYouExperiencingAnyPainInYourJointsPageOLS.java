package com.acurian.selenium.pages.OLS.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouExperiencingAnyPainInYourJointsPageOLS extends MainPageOLS{

    public final String titleExpected = "Thinking about your ulcerative colitis symptoms…\n"+
            "Are you experiencing any pain in your joints?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public AreYouExperiencingAnyPainInYourJointsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouExperiencingAnyPainInYourJointsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

      @Step
    public AreYouExperiencingAnyPainInYourJointsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
