package com.acurian.selenium.pages.CC.Derm_4631;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DupixentInjectionPageCC extends MainPageCC {

    public final String titleExpected = "Dupixent (dupilumab) is a biologic medication used to treat atopic dermatitis and certain types of asthma. It is given as a shot (injection).\n" +
            "Have you ever taken Dupixent, either currently or in the past?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public DupixentInjectionPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DupixentInjectionPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DupixentInjectionPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}