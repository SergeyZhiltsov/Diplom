package com.acurian.selenium.pages.blinx.ams.crohns;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PreviousDayDiarrheaOrLiquidStoolOLS extends MainPageBlinx {

    public final String titleExpected = "Thinking about your Crohn's disease symptoms…\n" +
            "Over the previous day, how many times did you have diarrhea or liquid stool?";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_RADIO_BUTTON_OLS_BLINX)
    WebElement titleText;


    @FindBy(xpath = "//div[@class='answers-container']//input")
    WebElement noStools;

    @Step
    public PreviousDayDiarrheaOrLiquidStoolOLS waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PreviousDayDiarrheaOrLiquidStoolOLS setStools(String text) {
        typeText(noStools, text);
        return this;
    }


    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
