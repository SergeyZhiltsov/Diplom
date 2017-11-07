package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YouIndicatedThatPageCC extends MainPageCC{

    public final String titleExpected1 = "You indicated that you would rate your current Crohn’s as 0. Based on this, do you feel your Crohn’s is currently in remission?";
    public final String titleExpected2 = "You indicated that you would rate your current Crohn’s as 1. Based on this, do you feel your Crohn’s is currently in remission?";
    public final String titleExpected3 = "You indicated that you would rate your current Crohn’s as 2. Based on this, do you feel your Crohn’s is currently in remission?";

    @FindBy(xpath = "//div[@class='subquestion']//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public YouIndicatedThatPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public YouIndicatedThatPageCC waitForPageLoad(String titleExpected) {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public YouIndicatedThatPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
