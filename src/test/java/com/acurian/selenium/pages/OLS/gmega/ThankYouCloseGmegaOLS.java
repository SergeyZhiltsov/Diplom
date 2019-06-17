package com.acurian.selenium.pages.OLS.gmega;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseGmegaOLS extends MainPageOLS {

    public final String titleExpected = "Thank you again for contacting Acurian's Research Information Center. To further allow us to assist you, please register with www.acurian.com and we will keep you informed of important treatment options for your condition.";

    String titleExpected_SB = "Thank you again for contacting Acurian's Research Information Center.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
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
    public ThankYouCloseGmegaOLS waitForPageLoad_SB() {
        waitForPageLoadMain(titleText, titleExpected_SB);
        return this;
    }


    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
