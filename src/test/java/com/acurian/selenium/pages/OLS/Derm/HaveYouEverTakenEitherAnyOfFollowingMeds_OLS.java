package com.acurian.selenium.pages.OLS.Derm;

import java.util.List;

import com.acurian.selenium.constants.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class HaveYouEverTakenEitherAnyOfFollowingMeds_OLS extends MainPageOLS {

    public final String titleExpected = "Have you ever taken any of the following medications?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]") //todo check
    WebElement titleText;
    @FindBy(xpath = Locators.CHEKBOX_LIST_OLS)
    List<WebElement> checkBoxList;

    @Step
    public HaveYouEverTakenEitherAnyOfFollowingMeds_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HaveYouEverTakenEitherAnyOfFollowingMeds_OLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
