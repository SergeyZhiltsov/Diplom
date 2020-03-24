package com.acurian.selenium.pages.CC.AST_4337;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class RespiratorySymptomsPageCC extends MainPageCC{

    public final String titleExpected = "In the past 6 months, have you received injections of any of the following medications for allergies, asthma, or respiratory symptoms?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public RespiratorySymptomsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public RespiratorySymptomsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public RespiratorySymptomsPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
