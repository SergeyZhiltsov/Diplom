package com.acurian.selenium.pages.CC.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OpioidOrNarcoticMedicationPageCC extends MainPageCC {

    public final String titleExpected = "Do you currently use opioid or narcotic medication every day?\n" +
            "\n" +
            "Examples of these medications include: Percocet, Oxycontin, oxycodone, Vicodin, hydrocodone, etc.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OpioidOrNarcoticMedicationPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OpioidOrNarcoticMedicationPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OpioidOrNarcoticMedicationPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
