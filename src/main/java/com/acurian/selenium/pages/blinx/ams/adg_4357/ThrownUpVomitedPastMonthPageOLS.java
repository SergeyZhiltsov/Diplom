package com.acurian.selenium.pages.blinx.ams.adg_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ThrownUpVomitedPastMonthPageOLS extends MainPageBlinx {

    public final String titleExpected = "How many times have you thrown up or vomited in the past month?";
    public final String titleExpected1 = "How many times in the past month have you vomited (thrown up) or had food or liquid come up into your throat and mouth after eating?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public ThrownUpVomitedPastMonthPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThrownUpVomitedPastMonthPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    @Step
    public ThrownUpVomitedPastMonthPageOLS waitForPageLoad1() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected1);
        return this;
    }

    @Step
    public ThrownUpVomitedPastMonthPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
