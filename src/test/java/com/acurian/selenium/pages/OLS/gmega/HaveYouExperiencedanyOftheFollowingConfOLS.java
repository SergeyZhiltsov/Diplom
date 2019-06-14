package com.acurian.selenium.pages.OLS.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HaveYouExperiencedanyOftheFollowingConfOLS extends MainPageOLS{

    public final String titleExpected = "Have you experienced any of the following conditions or procedures in the past 6 months?\n" +
            "Please check all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_OLS)
    WebElement titleText1;

    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_OLS)
    List<WebElement> checkBoxList_SB;

    public HaveYouExperiencedanyOftheFollowingConfOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HaveYouExperiencedanyOftheFollowingConfOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouExperiencedanyOftheFollowingConfOLS waitForPageLoadSB() {
        waitForPageLoadMain(titleText1, titleExpected);
        return this;
    }


    @Step
    public HaveYouExperiencedanyOftheFollowingConfOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public HaveYouExperiencedanyOftheFollowingConfOLS clickOnAnswers_SB(String ...answerText) {
        clickOnCheckBoxes(checkBoxList_SB, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
