package com.acurian.selenium.pages.OLS.Vaccine_4556;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS extends MainPageOLS {

    private final String titleExpected = "Have you ever been diagnosed with any of the following types of cancer?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    private WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    private List<WebElement> radioButtonsList;

    public DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithAnyOfTheFollowingTypesOfCancerOLS clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
