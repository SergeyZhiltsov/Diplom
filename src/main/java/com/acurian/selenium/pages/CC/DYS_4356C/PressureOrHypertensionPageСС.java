package com.acurian.selenium.pages.CC.DYS_4356C;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PressureOrHypertensionPageСС extends MainPageCC{

    public final String titleExpected = "Has a doctor ever diagnosed you with high blood pressure or hypertension?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public PressureOrHypertensionPageСС() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PressureOrHypertensionPageСС waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PressureOrHypertensionPageСС clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
