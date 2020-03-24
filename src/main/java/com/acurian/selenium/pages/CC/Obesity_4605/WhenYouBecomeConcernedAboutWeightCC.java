package com.acurian.selenium.pages.CC.Obesity_4605;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.Obesity_4605.WhenYouBecomeConcernedAboutWeightOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenYouBecomeConcernedAboutWeightCC extends MainPageCC {
    private final String titleExpected = "When did you (or your parents or caregivers) first become concerned about your weight?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public WhenYouBecomeConcernedAboutWeightCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhenYouBecomeConcernedAboutWeightCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhenYouBecomeConcernedAboutWeightCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
