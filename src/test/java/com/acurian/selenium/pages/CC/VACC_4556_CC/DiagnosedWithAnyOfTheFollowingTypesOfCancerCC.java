package com.acurian.selenium.pages.CC.VACC_4556_CC;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.OLS.Vaccine_4556.DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithAnyOfTheFollowingTypesOfCancerCC extends MainPageCC {
    private final String titleExpected = "Have you ever been diagnosed with any of the following types of cancer?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    private WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    private List<WebElement> radioButtonsList;

    public DiagnosedWithAnyOfTheFollowingTypesOfCancerCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithAnyOfTheFollowingTypesOfCancerCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithAnyOfTheFollowingTypesOfCancerCC clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
