package com.acurian.selenium.pages.OLS.UC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowWouldYouRateYourGeneralWellBeingPageOLS extends MainPageOLS{

    public final String titleExpected = "Thinking about your ulcerative colitis symptoms…\n"+
            "Over the previous day, how would you rate your general well-being?";


    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HowWouldYouRateYourGeneralWellBeingPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouRateYourGeneralWellBeingPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

      @Step
    public HowWouldYouRateYourGeneralWellBeingPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
