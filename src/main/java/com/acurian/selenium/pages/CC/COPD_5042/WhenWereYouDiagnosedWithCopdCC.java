package com.acurian.selenium.pages.CC.COPD_5042;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenWereYouDiagnosedWithCopdCC extends MainPageCC {

    public final String titleExpected = "When were you diagnosed with COPD?";

    @FindBy(xpath = "//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public WhenWereYouDiagnosedWithCopdCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenWereYouDiagnosedWithCopdCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenWereYouDiagnosedWithCopdCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}