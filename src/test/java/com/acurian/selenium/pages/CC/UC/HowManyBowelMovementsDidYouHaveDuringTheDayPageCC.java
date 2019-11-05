package com.acurian.selenium.pages.CC.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowManyBowelMovementsDidYouHaveDuringTheDayPageCC extends MainPageCC {

    public final String titleExpected = "Thinking about your ulcerative colitis symptoms…\n"+
            "Over the previous day, how many bowel movements did you have during the day?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HowManyBowelMovementsDidYouHaveDuringTheDayPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyBowelMovementsDidYouHaveDuringTheDayPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowManyBowelMovementsDidYouHaveDuringTheDayPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
