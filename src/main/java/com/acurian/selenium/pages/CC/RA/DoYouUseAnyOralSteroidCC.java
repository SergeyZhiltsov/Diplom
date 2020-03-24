package com.acurian.selenium.pages.CC.RA;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class DoYouUseAnyOralSteroidCC extends MainPageCC{

    public final String titleExpected = "Do you currently use any oral (taken by mouth) steroid medications every day or every other day to treat or manage your RA?\n" +
            "Commonly used types of steroids include prednisone, prednisolone, dexamethasone, methylprednisolone, and Medrol.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DoYouUseAnyOralSteroidCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouUseAnyOralSteroidCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouUseAnyOralSteroidCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
