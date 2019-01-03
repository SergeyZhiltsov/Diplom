package com.acurian.selenium.pages.CC.RA_2821.standalone;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ExperiencedAnyOfTheFollowingConditionsInPast6Months extends MainPageCC {
    public final String titleExpected = "Have you experienced any of the following conditions or procedures in the past 6 months?\n" +
            "Please check all that apply:";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_CC)
    List<WebElement> checkBoxList;

    public ExperiencedAnyOfTheFollowingConditionsInPast6Months() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ExperiencedAnyOfTheFollowingConditionsInPast6Months waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ExperiencedAnyOfTheFollowingConditionsInPast6Months clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
