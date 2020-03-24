package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HasHealthCareProfessionalDiagnosedPsoriasisCC extends MainPageCC {

    public final String titleExpected = "Psoriasis is an autoimmune condition that causes the body to produce too many" +
            " skin cells. Raised, red patches with silvery scales, called plaques, form on your skin. The plaques may be painful or itch.\n" +
            "\n" +
            "Has a healthcare professional ever diagnosed you with psoriasis? (Agent Note: suh-rahy-uh-sis)";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonList;

    public HasHealthCareProfessionalDiagnosedPsoriasisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HasHealthCareProfessionalDiagnosedPsoriasisCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
