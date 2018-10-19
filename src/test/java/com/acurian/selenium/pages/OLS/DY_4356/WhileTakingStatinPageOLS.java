package com.acurian.selenium.pages.OLS.DY_4356;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhileTakingStatinPageOLS extends MainPageOLS{

    public final String titleExpected = "One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is called a statin. Most people with these conditions are prescribed this kind of medicine. Statins are prescribed under many different names.\n" +
            "\n" +
            "Which of the following statin medications have you ever taken on a daily basis?\n" +
            "Think about statin medications you may be taking now as well as those you may have taken in the past.\n" +
            "Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhileTakingStatinPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhileTakingStatinPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhileTakingStatinPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
