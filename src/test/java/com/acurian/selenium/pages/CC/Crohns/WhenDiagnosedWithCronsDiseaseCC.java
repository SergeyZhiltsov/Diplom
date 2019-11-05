package com.acurian.selenium.pages.CC.Crohns;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhenDiagnosedWithCronsDiseaseCC extends MainPageCC {
    public final String titleExpected = "When were you diagnosed with Crohn's disease?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public WhenDiagnosedWithCronsDiseaseCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }


    @Step
    public WhenDiagnosedWithCronsDiseaseCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
