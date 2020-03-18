package com.acurian.selenium.pages.blinx.ams.gerd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DidTakeMedicationToTreatPyloriOLS extends MainPageBlinx {

    public final String titleExpected = "Did you take medication to treat your H. pylori infection?\n" +
            "Typical treatment is multiple medications, all taken together for a 2 week period, including two or more antibiotics and a proton pump inhibitor (such as Nexium, Prilosec, or Prevacid).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public DidTakeMedicationToTreatPyloriOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DidTakeMedicationToTreatPyloriOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
