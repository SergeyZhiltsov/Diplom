package com.acurian.selenium.pages.OLS.HOTF_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS extends MainPageOLS {

    public final String titleExpected = "Are you currently treating your hot flashes with a prescription medication that is taken by mouth or by injection?\n" +
            "This most commonly includes hormonal therapy containing estrogen or progestin, but may also include certain antidepressants or other options.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouCurrentlyTreatingYourHotFlashesWithPrescriptionMedicationOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
