package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class LiverRelatedConditionOLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of the following liver-related conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public LiverRelatedConditionOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LiverRelatedConditionOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public LiverRelatedConditionOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
