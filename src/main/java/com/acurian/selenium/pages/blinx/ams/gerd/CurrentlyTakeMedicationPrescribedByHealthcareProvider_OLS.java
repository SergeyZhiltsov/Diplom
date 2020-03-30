package com.acurian.selenium.pages.blinx.ams.gerd;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CurrentlyTakeMedicationPrescribedByHealthcareProvider_OLS extends MainPageBlinx {

    public final String titleExpected = "Do you currently take a medication prescribed by your healthcare provider to treat your heartburn, reflux, or GERD?\n" +
            "Typical medications prescribed by healthcare providers for heartburn, reflux, or GERD include Nexium, " +
            "Prevacid, Prilosec, Zegerid, Aciphex, Dexilant, and Protonix, which are \"Proton Pump Inhibitors\" or \"PPI\".";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public CurrentlyTakeMedicationPrescribedByHealthcareProvider_OLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public CurrentlyTakeMedicationPrescribedByHealthcareProvider_OLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
