package com.acurian.selenium.pages.blinx.ams.chronic_cough;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowLongYouHadChronicCoughOLS extends MainPageBlinx {

    public final String titleExpected = "How long have you had your chronic cough?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public HowLongYouHadChronicCoughOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongYouHadChronicCoughOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowLongYouHadChronicCoughOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
