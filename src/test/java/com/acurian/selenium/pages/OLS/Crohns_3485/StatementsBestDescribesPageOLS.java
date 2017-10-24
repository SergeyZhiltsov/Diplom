package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class StatementsBestDescribesPageOLS extends MainPageOLS{

    public final String titleExpected = "Which of the following statements best describes what you are currently experiencing with your Crohn’s?\n" +
            "\n" +
            "A flare is defined as when symptoms such as strong abdominal cramps, bloody diarrhea, fever, unusual gas and even weight loss reappear.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public StatementsBestDescribesPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StatementsBestDescribesPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StatementsBestDescribesPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
