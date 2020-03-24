package com.acurian.selenium.pages.CC.Obesity_4605;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.Obesity_4605.DiagnosedWithPraderWilliSyndromeOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithPraderWilliSyndromeCC extends MainPageCC {
    private final String titleExpected = "Have you ever been diagnosed with a genetic disorder called Prader-Willi syndrome?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public DiagnosedWithPraderWilliSyndromeCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithPraderWilliSyndromeCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithPraderWilliSyndromeCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
