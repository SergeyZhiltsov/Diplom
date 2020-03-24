package com.acurian.selenium.pages.OLS.Crohns;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PreviousDayDiarrheaOrLiquidStoolOLS extends MainPageOLS {

    public final String titleExpected = "Thinking about your Crohn's disease symptoms…\n" +
            "Over the previous day, how many times did you have diarrhea or liquid stool?";

    @FindBy(xpath = "(//*[contains(@class, 'visible-md-block')])[1]")
    WebElement titleText;


    @FindBy(xpath = "//*[@id='QS8113']")
    WebElement noStools;

    @Step
    public PreviousDayDiarrheaOrLiquidStoolOLS waitForPageLoad() {
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
