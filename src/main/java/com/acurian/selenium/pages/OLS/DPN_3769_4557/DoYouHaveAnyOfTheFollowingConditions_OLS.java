package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouHaveAnyOfTheFollowingConditions_OLS extends MainPageOLS {

    public final String titleExpected = "Do you have any of the following conditions related to your diabetes?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "(//div[contains(@class,'visible-md-block')])[2]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    @Step
    public DoYouHaveAnyOfTheFollowingConditions_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouHaveAnyOfTheFollowingConditions_OLS clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}