package com.acurian.selenium.pages.blinx.ams.dpn_5096;

import com.acurian.selenium.pages.blinx.MainPageBlinx;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HowWouldYouRateYourPain_OLSTODO extends MainPageBlinx {

    public final String titleExpected = "How would you rate your pain or discomfort on a scale of 0 to 10?\n" +
            "0 means no pain or discomfort at all, and 10 is the worst pain or discomfort you can imagine.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]") //???
    WebElement titleText;
    @FindBy(xpath = "//select[@id='QS5510']") //???
    WebElement painSelect;

    @Step
    public HowWouldYouRateYourPain_OLSTODO waitForPageLoad() {
        waitForAnimation();
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouRateYourPain_OLSTODO selectPainRating(String rating) {
        selectDropDownListOptionByText(painSelect, rating);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
