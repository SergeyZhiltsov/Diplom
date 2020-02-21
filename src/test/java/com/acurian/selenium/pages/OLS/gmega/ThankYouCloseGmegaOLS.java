package com.acurian.selenium.pages.OLS.gmega;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseGmegaOLS extends MainPageOLS {

    public final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. To further allow us to assist you, please register with www.acurian.com and we will keep you informed of important treatment options for your condition.";
    public final String titleExpectedSB = "Thank you again for contacting Acurian's Research Information Center.";
    public final String titleExpectedGBAN = "Thank you again for contacting Acurian's Research Information Center. To further allow us to assist you, please register with www.acurianhealth.com and we will keep you informed of important treatment options for your condition.";

//    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
//    WebElement titleText;

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_RADIO_BUTTON_OLS)
    WebElement titleText;

    public ThankYouCloseGmegaOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseGmegaOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ThankYouCloseGmegaOLS waitForPageLoadByTitle(String title) {
        waitForPageLoadMain(titleText, title);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
