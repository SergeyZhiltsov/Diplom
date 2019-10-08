package com.acurian.selenium.pages.CC.GERD;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DidTakeMedicationToTreatPyloriCC extends MainPageCC {

    public final String titleExpected = "Did you take medication to treat your H. pylori infection?\n" +
            "Typical treatment is multiple medications, all taken together for a 2 week period, including two or more antibiotics and a proton pump inhibitor (such as Nexium, Prilosec, or Prevacid).";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public DidTakeMedicationToTreatPyloriCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DidTakeMedicationToTreatPyloriCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
