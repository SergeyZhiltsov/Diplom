package com.acurian.selenium.pages.CC.DPN_3769_4557;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhereDoYouExperienceDiabeticNervePain_CC extends MainPageCC {

    public final String titleExpected = "Where do you experience diabetic nerve pain symptoms or sensations?\n" +
            "Agent Note: Select all that apply";
    public final String titleExpectedDPN = "Where do you experience pain?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;
    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    @Step
    public WhereDoYouExperienceDiabeticNervePain_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_CC waitForPageLoadDPN() {
        waitForPageLoadMain(titleText, titleExpectedDPN);
        return this;
    }

    @Step
    public WhereDoYouExperienceDiabeticNervePain_CC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}