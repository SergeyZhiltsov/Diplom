package com.acurian.selenium.pages.blinx.ams.ps;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasHealthCareProfessionalDiagnosedPsoriasisOLS extends MainPageBlinx {

    public final String titleExpected = "Psoriasis is an autoimmune condition that causes the body to produce too many" +
            " skin cells. Raised, red patches with silvery scales, called plaques, form on your skin. The plaques may be painful or itch.\n" +
            "\n" +
            "Has a healthcare professional ever diagnosed you with psoriasis?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
