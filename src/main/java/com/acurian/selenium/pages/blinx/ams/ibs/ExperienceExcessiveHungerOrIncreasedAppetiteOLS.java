package com.acurian.selenium.pages.blinx.ams.ibs;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ExperienceExcessiveHungerOrIncreasedAppetiteOLS extends MainPageBlinx {

    private final String titleExpected = "Do you experience excessive hunger or increased appetite, or abnormal food-seeking behaviors?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    private WebElement titleText;

    @FindBy(xpath = Locators.RADIO_BUTTON_LIST_OLS)
    private List<WebElement> radioButtonsList;

    public ExperienceExcessiveHungerOrIncreasedAppetiteOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ExperienceExcessiveHungerOrIncreasedAppetiteOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ExperienceExcessiveHungerOrIncreasedAppetiteOLS clickOnAnswer(String answer) {
        clickOnRadioButton(radioButtonsList, answer);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
