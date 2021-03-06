package com.acurian.selenium.pages.CC.HOTF_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnAvgHowManyHotFlashesDoYouExperiencePerDayCC extends MainPageCC {

    public final String titleExpected = "On average, how many hot flashes do you experience per day?\n" +
            "Please think about a full 24-hour period, including nighttime.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_CC)
    List<WebElement> radioButtonsList;

    public OnAvgHowManyHotFlashesDoYouExperiencePerDayCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OnAvgHowManyHotFlashesDoYouExperiencePerDayCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OnAvgHowManyHotFlashesDoYouExperiencePerDayCC clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
