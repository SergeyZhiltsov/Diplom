package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseSimplePageOLS extends MainPageOLS {

    //Thank You Close - AWR/SEN - 65
    public final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.";
    //Thank You Close - SEN-R - 66
    public final String titleExpected_OA3138 = "Thank you again for contacting Acurian's Research Information Center. Goodbye.";

    public final String titleExpected2 = "Thank you again for contacting Acurian's Research Information Center.";


    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText_OA3138;


    @Step
    public ThankYouCloseSimplePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        attachPageScreenshot();
        return this;
    }

    @Step
    public ThankYouCloseSimplePageOLS waitForSENRPageLoad() {
        waitForPageLoadMain(titleText_OA3138, titleExpected_OA3138);
        return this;
    }

    /**
     * Created on 26.11.2019 by Ivan
     * @return
     */
    @Step
    public ThankYouCloseSimplePageOLS waitForPageLoad2() {
        waitForPageLoadMain(titleText_OA3138, titleExpected2);
        attachPageScreenshot();
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
