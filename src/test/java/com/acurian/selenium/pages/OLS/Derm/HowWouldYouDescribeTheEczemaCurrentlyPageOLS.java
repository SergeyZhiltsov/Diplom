package com.acurian.selenium.pages.OLS.Derm;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HowWouldYouDescribeTheEczemaCurrentlyPageOLS extends MainPageOLS {

    public final String titleExpected = "Sometimes eczema comes and goes, flaring up at times and then improving or even clearing completely.\n" +
            "How would you describe the eczema currently on your body?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    List<WebElement> radioButtonsList;

    @Step
    public HowWouldYouDescribeTheEczemaCurrentlyPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouDescribeTheEczemaCurrentlyPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
