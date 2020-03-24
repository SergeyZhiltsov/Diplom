package com.acurian.selenium.pages.OLS.COPD_5042;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichFollowingInhalersdoYouUseCopdOLS extends MainPageOLS {

    public final String titleExpected = "Which of the following inhalers or nebulizers do you currently use to manage your COPD?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichFollowingInhalersdoYouUseCopdOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichFollowingInhalersdoYouUseCopdOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichFollowingInhalersdoYouUseCopdOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}