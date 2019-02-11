package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import com.acurian.selenium.pages.CC.shared.HasHealthcareProfessionalEverDiagnosedYouWithEczema_CC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiagnosedWithPsoriasisCC extends MainPageCC {
    public final String titleExpected = "Has a healthcare professional ever diagnosed you with psoriasis? (Agent Note: suh-rahy-uh-sis)\n" +
            "Psoriasis is an autoimmune condition that causes too many skin cells. Your skin forms raised, red plaques covered with silvery scales, " +
            "which may be painful or itch.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public DiagnosedWithPsoriasisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithPsoriasisCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithPsoriasisCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
