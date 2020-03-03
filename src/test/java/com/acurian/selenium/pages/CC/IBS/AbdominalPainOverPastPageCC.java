package com.acurian.selenium.pages.CC.IBS;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AbdominalPainOverPastPageCC extends MainPageCC{

    public final String titleExpected = "With IBS, abdominal pain is often accompanied by a change in bowel habits.\n" +
            "Which of the following have you had with your abdominal pain over the past 3 months?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public AbdominalPainOverPastPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AbdominalPainOverPastPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AbdominalPainOverPastPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
