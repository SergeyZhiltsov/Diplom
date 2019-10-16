package com.acurian.selenium.pages.CC.Gout;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverDiagnosedWithGoutCC extends MainPageCC {
    public final String titleExpected = "Gout is a type of arthritis in which crystals build up in your joints.  These crystals form when you have high levels of a substance called uric acid in your blood.\n" +
            "Has a doctor ever diagnosed you with gout?\n";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    @Step
    public EverDiagnosedWithGoutCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverDiagnosedWithGoutCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
