package com.acurian.selenium.pages.OLS.LOWT_3017;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ExperiencedAnyOfFollowingOLS extends MainPageOLS{

    public final String titleExpected = "Have you experienced any of the following?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public ExperiencedAnyOfFollowingOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ExperiencedAnyOfFollowingOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ExperiencedAnyOfFollowingOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
