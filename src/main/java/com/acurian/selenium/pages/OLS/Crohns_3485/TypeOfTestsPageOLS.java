package com.acurian.selenium.pages.OLS.Crohns_3485;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TypeOfTestsPageOLS extends MainPageOLS{

    public final String titleExpected = "Which of the following types of tests/procedures have you ever had to diagnose your Crohn’s disease?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public TypeOfTestsPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TypeOfTestsPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public TypeOfTestsPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
