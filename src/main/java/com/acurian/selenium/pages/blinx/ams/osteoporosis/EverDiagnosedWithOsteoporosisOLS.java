package com.acurian.selenium.pages.blinx.ams.osteoporosis;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class EverDiagnosedWithOsteoporosisOLS extends MainPageBlinx {

    public final String titleExpected = "Osteoporosis is a common problem that causes bones to become abnormally thin, weak and easily broken (fractured).\n" +
            "Has a doctor ever diagnosed you with osteoporosis by bone density testing?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public EverDiagnosedWithOsteoporosisOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public EverDiagnosedWithOsteoporosisOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
