package com.acurian.selenium.pages.CC.COPD_5042;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC extends MainPageCC {

    public final String titleExpected = "Are you currently taking any inhaled or nebulized medications to treat your COPD?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTakingAnyInhaledNebulizedMedstoCopdCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}