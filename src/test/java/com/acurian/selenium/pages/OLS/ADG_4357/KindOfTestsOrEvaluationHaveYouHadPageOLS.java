package com.acurian.selenium.pages.OLS.ADG_4357;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class KindOfTestsOrEvaluationHaveYouHadPageOLS extends MainPageOLS {

    public final String titleExpected = "What kind(s) of tests or evaluation have you had for your gastroparesis symptoms?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public KindOfTestsOrEvaluationHaveYouHadPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public KindOfTestsOrEvaluationHaveYouHadPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public KindOfTestsOrEvaluationHaveYouHadPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
