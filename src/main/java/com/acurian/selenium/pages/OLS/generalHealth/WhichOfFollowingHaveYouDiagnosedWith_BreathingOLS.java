package com.acurian.selenium.pages.OLS.generalHealth;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;


import ru.yandex.qatools.allure.annotations.Step;

public class WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS extends MainPageOLS{

    public final String titleExpected = "You reported that you have breathing, lung, or respiratory issues.\n" +
    		"Which of the following have you been diagnosed with?\n" +
    		"Please select all that apply.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    public WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfFollowingHaveYouDiagnosedWith_BreathingOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
