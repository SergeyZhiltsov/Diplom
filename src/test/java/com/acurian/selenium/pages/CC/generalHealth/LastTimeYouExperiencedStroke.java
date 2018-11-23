package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LastTimeYouExperiencedStroke extends MainPageCC {
    private final String textExpected = "When was the last time that you experienced a stroke?";

    @FindBy(xpath = "//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> checkBoxList;

    public LastTimeYouExperiencedStroke() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LastTimeYouExperiencedStroke waitForPageLoad() {
        waitForPageLoadMain(titleText, textExpected);
        return this;
    }

    @Step
    public LastTimeYouExperiencedStroke clickOnAnswer(String answer) {
        clickOnRadioButton(checkBoxList, answer);
        return this;
    }
}
