package com.acurian.selenium.pages.OLS.HOTF_7119;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS extends MainPageOLS {

    public final String titleExpected = "On average, how many hot flashes do you experience per day?\n" +
            "Please think about a full 24-hour period, including nighttime.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    public OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public OnAvgHowManyHotFlashesDoYouExperiencePerDayOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
