package com.acurian.selenium.pages.CC.HOTF_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC extends MainPageCC {

    public final String titleExpected = "Are you currently treating your hot flashes with a prescription medication that is taken by mouth or by injection?\n" +
            "This most commonly includes hormonal therapy containing estrogen or progestin, but may also include certain antidepressants or other options.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
