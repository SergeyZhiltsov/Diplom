package com.acurian.selenium.pages.CC.PSO_456;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichTypeOfPsoriasisCC extends MainPageCC {
    public final String titleExpected = "Which type(s) of psoriasis do you have?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkboxList;

    public WhichTypeOfPsoriasisCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichTypeOfPsoriasisCC waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichTypeOfPsoriasisCC clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkboxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
