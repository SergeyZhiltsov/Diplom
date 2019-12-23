package com.acurian.selenium.pages.blinx.ams.shared;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedAnyTypeOfDiabetesPageOLS extends MainPageBlinx {

    public final String titleExpected = "Have you been diagnosed with any type of diabetes?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;


    @Step
    public DiagnosedAnyTypeOfDiabetesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedAnyTypeOfDiabetesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
