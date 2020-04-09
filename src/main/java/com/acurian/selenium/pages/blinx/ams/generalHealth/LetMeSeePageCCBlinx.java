package com.acurian.selenium.pages.blinx.ams.generalHealth;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class LetMeSeePageCCBlinx extends MainPageBlinx {

    public final String titleExpected = "Thank you, let me see if there are any follow-up questions that we need to ask based on the conditions that you experience.";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;

    @Step
    public LetMeSeePageCCBlinx waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    public LetMeSeePageCCBlinx() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
