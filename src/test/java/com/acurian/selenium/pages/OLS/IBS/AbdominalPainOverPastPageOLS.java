package com.acurian.selenium.pages.OLS.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AbdominalPainOverPastPageOLS extends MainPageOLS{

    public final String titleExpected = "With IBS, abdominal pain is often accompanied by a change in bowel habits.\n" +
            "Which of the following have you had with your abdominal pain over the past 3 months?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public AbdominalPainOverPastPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AbdominalPainOverPastPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AbdominalPainOverPastPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
