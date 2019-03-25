package com.acurian.selenium.pages.CC.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class HowLongTakingPlaquenilCC extends MainPageCC{

    public final String titleExpected = "How long have you been taking Plaquenil (hydroxychloroquine)?";

    @FindBy(xpath = "//div[@class='subquestion']/span[1]")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public HowLongTakingPlaquenilCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowLongTakingPlaquenilCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowLongTakingPlaquenilCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
