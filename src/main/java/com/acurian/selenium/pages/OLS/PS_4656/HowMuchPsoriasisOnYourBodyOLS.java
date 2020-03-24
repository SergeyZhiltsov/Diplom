package com.acurian.selenium.pages.OLS.PS_4656;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HowMuchPsoriasisOnYourBodyOLS extends MainPageOLS {

    public final String titleExpected = "We need to understand how much psoriasis you have on your body.\n\n" +
            "Use your hand to cover all of the psoriasis patches currently on your skin. About how many hand prints does it take to cover all the psoriasis on your body?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = Locators.BASIC_DROPDOWN_LIST)
    WebElement dropDownList;

    @Step
    public HowMuchPsoriasisOnYourBodyOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowMuchPsoriasisOnYourBodyOLS selectFromDropDown(String answerText) {
        selectDropDownListOptionByText(dropDownList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
