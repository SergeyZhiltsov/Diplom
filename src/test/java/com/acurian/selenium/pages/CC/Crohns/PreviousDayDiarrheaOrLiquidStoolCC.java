package com.acurian.selenium.pages.CC.Crohns;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class PreviousDayDiarrheaOrLiquidStoolCC extends MainPageCC {

    public final String titleExpected = "Thinking about your Crohn's disease symptoms…\n" +
            "Over the previous day, how many times did you have diarrhea or liquid stool?";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;


    @FindBy(xpath = "//input[contains(@class,'input-text')]")
    WebElement noStools;

    @Step
    public PreviousDayDiarrheaOrLiquidStoolCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public PreviousDayDiarrheaOrLiquidStoolCC setStools(String text) {
        typeText(noStools, text);
        return this;
    }


    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
