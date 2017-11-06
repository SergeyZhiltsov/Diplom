package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StatementsBestDescribesPageCC extends MainPageCC{

    public final String titleExpected = "Which of the following statements best describes what you are currently experiencing with your Crohn’s?\n" +
            "\n" +
            "A flare is defined as when symptoms such as strong abdominal cramps, bloody diarrhea, fever, unusual gas and even weight loss reappear.\n" +
            "\n" +
            "The statements are:\n" +
            "Agent Note: Read list ";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public StatementsBestDescribesPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StatementsBestDescribesPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StatementsBestDescribesPageCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
