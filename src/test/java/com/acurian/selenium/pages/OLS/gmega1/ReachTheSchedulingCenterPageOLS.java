package com.acurian.selenium.pages.OLS.gmega1;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ReachTheSchedulingCenterPageOLS extends MainPageOLS{

    public final String titleExpected = "We're glad the location is convenient for you. I would like to transfer you to the doctor's scheduling center.\n" +
            "Please hold for just a minute while I try to reach the scheduling center.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public ReachTheSchedulingCenterPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ReachTheSchedulingCenterPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ReachTheSchedulingCenterPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
