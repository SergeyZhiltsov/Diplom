package com.acurian.selenium.pages.blinx.ams.adg_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OpioidOrNarcoticMedicationPageOLS extends MainPageBlinx {

    public final String titleExpected = "Do you currently use opioid or narcotic medication every day?\n" +
            "\n" +
            "Examples of these medications include: Percocet, Oxycontin, oxycodone, Vicodin, hydrocodone, etc.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public OpioidOrNarcoticMedicationPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OpioidOrNarcoticMedicationPageOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OpioidOrNarcoticMedicationPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
