package com.acurian.selenium.pages.CC.Obesity_4605;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.Obesity_4605.PlanningBiatricOrWeightLossSurgeryOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PlanningBiatricOrWeightLossSurgeryCC extends MainPageCC {
    private final String titleExpected = "Are you planning to have any type of bariatric or weight loss surgery?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    private List<WebElement> radioButtonsList;

    public PlanningBiatricOrWeightLossSurgeryCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public PlanningBiatricOrWeightLossSurgeryCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PlanningBiatricOrWeightLossSurgeryCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
