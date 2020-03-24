package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatfillThankYouPageOLS extends MainPageOLS {

    public final String titleExpected = "Thank You for Submitting the form";

    @FindBy(xpath = "//h3[@class='thank-text']")
    WebElement titleText;

    public ChatfillThankYouPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    public ChatfillThankYouPageOLS waitForPageLoad() {
        waitForAnimation();
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("chartfill-iframe");
        getDriver().switchTo().frame("adobeSign");
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
}
