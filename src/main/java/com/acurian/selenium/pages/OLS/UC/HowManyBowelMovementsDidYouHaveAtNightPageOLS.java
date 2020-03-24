package com.acurian.selenium.pages.OLS.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowManyBowelMovementsDidYouHaveAtNightPageOLS extends MainPageOLS{

    public final String titleExpected = "Thinking about your ulcerative colitis symptoms…\n"+
            "Over the previous day, how many bowel movements did you have at night?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HowManyBowelMovementsDidYouHaveAtNightPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowManyBowelMovementsDidYouHaveAtNightPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

      @Step
    public HowManyBowelMovementsDidYouHaveAtNightPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
