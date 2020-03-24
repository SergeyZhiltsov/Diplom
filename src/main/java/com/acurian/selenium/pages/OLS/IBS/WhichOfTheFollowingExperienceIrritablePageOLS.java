package com.acurian.selenium.pages.OLS.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfTheFollowingExperienceIrritablePageOLS extends MainPageOLS{

//    public final String titleExpected = "Which of the following do you experience with your irritable bowel syndrome or IBS?";
    public final String titleExpected = "Which of the following bowel habits do you experience with your irritable bowel syndrome or IBS?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public WhichOfTheFollowingExperienceIrritablePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfTheFollowingExperienceIrritablePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfTheFollowingExperienceIrritablePageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
