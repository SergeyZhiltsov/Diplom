package com.acurian.selenium.pages.OLS.Crohns;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCrohnsPage_OLS extends MainPageOLS {
    public final String titleExpected = "Thank you for answering the questions about your Crohn's history.\n" +
            "I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me “yes” or “no,” and I will check off each condition that you do have.\n" +
            "If “no” to all items in a question, select “None of the above”";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    @Step
    public ThankYouCrohnsPage_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }


    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}