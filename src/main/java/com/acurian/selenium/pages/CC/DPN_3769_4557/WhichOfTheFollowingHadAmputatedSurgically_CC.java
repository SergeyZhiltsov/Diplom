package com.acurian.selenium.pages.CC.DPN_3769_4557;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class WhichOfTheFollowingHadAmputatedSurgically_CC extends MainPageCC {

    public final String titleExpected = "Which of the following have you had amputated or surgically removed because of your diabetes?\n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;
    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    @Step
    public WhichOfTheFollowingHadAmputatedSurgically_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichOfTheFollowingHadAmputatedSurgically_CC clickOnAnswers(String... answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}