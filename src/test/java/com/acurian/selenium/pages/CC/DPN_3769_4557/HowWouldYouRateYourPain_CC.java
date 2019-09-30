package com.acurian.selenium.pages.CC.DPN_3769_4557;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


public class HowWouldYouRateYourPain_CC<Just> extends MainPageCC {

    public final String titleExpected = "How would you rate your pain or discomfort on a scale of 0 to 10?\n" +
            "0 means no pain or discomfort at all, and 10 is the worst pain or discomfort you can imagine.";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;
    @FindBy(xpath = "//select[@id='QS5510']")
    WebElement painSelect;

    @Step
    public HowWouldYouRateYourPain_CC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HowWouldYouRateYourPain_CC selectPainRating(String rating) {
        selectDropDownListOptionByText(painSelect, rating);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}