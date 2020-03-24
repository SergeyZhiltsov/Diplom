package com.acurian.selenium.pages.CC.DPN_3769_4557;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DoYouHaveAnyOfTheFollowingConditions_CC extends MainPageCC {

    public final String titleExpected = "Do you have any of the following conditions related to your diabetes?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//span[@class='sub_question_text']//div[@class='show-in-cc']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    @Step
    public DoYouHaveAnyOfTheFollowingConditions_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouHaveAnyOfTheFollowingConditions_CC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}