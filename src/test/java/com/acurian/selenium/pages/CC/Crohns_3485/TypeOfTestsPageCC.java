package com.acurian.selenium.pages.CC.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfTestsPageCC extends MainPageCC{

    public final String titleExpected = "Next, please tell me which of the following types of tests/procedures have you ever had to diagnose your Crohn’s disease? Let’s start with:\n" +
            "Agent Note: Select all that apply; Read list";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_CC)
    List<WebElement> checkBoxList;

    public TypeOfTestsPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TypeOfTestsPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfTestsPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
