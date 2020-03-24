package com.acurian.selenium.pages.CC.IBD;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class OtherPrescriptionMedicinesIBDShort extends MainPageCC{

    public final String titleExpected = "Have you ever taken any other prescription medicines to treat or manage your Crohn’s or colitis?";   

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OtherPrescriptionMedicinesIBDShort() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OtherPrescriptionMedicinesIBDShort waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }   
   
    @Step
    public OtherPrescriptionMedicinesIBDShort clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
