package com.acurian.selenium.pages.CC.PsoriaticArthritis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverReceivedAnyBiologicMedicationsPageCC extends MainPageCC {

    public final String titleExpected = "Have you ever received regular doses of any \"biologic\" medications?\n" +
            "\"Biologics\" are medications that affect the body’s immune system. They are given as an infusion " +
            "(into a vein) or an injection (a shot under the skin).\n" +
            "Agent Note:\n" +
            "List of biologic medications is included for reference. Please do not read the full list to the caller.\n" +
            "·   Actemra (Agent Note: ac-TEM-ruh)\n" +
            "·   Benlysta (Agent Note: ben-LIST-uh)\n" +
            "·   Cimzia (Agent Note: SIM-zee-uh)\n" +
            "·   Cosentyx (Agent Note: co-SEN-tix)\n" +
            "·   Enbrel (Agent Note: EN-brel)\n" +
            "·   Entyvio (Agent Note: en-TIV-ee-oh)\n" +
            "·   Humira (Agent Note: hue-MAIR-uh)\n" +
            "·   Kineret (Agent Note: KIN-er-et)\n" +
            "·   Orencia (Agent Note: oh-REN-see-uh)\n" +
            "·   Prolia or Xgeva (Agent Note: PRO-lee-uh, ex-GEE-vuh)\n" +
            "·   Raptiva (Agent Note: rap-TEE-vuh)\n" +
            "·   Remicade (Agent Note: REM-ih-cade)\n" +
            "·   Rituxan (Agent Note: rih-TUX-an)\n" +
            "·   Simponi (Agent Note: SIM-po-nee)\n" +
            "·   Stelara (Agent Note: ste-LAHR-uh)\n" +
            "·   Taltz (Agent Note: TALTS)\n" +
            "·   Tysabri (Agent Note: tie-SAB-ree)";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public EverReceivedAnyBiologicMedicationsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverReceivedAnyBiologicMedicationsPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
