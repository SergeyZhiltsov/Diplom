package com.acurian.selenium.pages.CC.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class LastTimeYouExperiencedAngina extends MainPageCC {
    private final String titleExpected = "When was the last time that you experienced angina or chest pain that required an overnight hospital stay?";

    @FindBy(xpath = "//span[@class='sub_question_text']")
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> checkBoxList;

    public LastTimeYouExperiencedAngina() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public LastTimeYouExperiencedAngina waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    public LastTimeYouExperiencedAngina clickOnAnswer(String answer) {
        clickOnRadioButton(checkBoxList, answer);
        return this;
    }
}
