package com.acurian.selenium.pages.OLS.AMIG_4742;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PrescriptionMedicationsDailyToPreventMigrainesPageOLS extends MainPageOLS {

    public final String titleExpected = "How satisfied are you with the prescription medications that you take daily to prevent migraines from starting?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public PrescriptionMedicationsDailyToPreventMigrainesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PrescriptionMedicationsDailyToPreventMigrainesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PrescriptionMedicationsDailyToPreventMigrainesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);;
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}