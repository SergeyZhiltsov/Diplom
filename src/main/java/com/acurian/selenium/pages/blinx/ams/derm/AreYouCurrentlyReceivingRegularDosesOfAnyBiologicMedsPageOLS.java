package com.acurian.selenium.pages.blinx.ams.derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS extends MainPageBlinx {

    public final String titleExpected = "Are you currently receiving regular doses of any \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body’s immune system. They are given as an infusion (into a vein) or an injection (a shot under the skin).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyReceivingRegularDosesOfAnyBiologicMedsPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
