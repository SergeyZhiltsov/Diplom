package com.acurian.selenium.pages.OLS.closes;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouCloseSimplePageOLS extends MainPageOLS{

    public final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.";

    public final String titleExpected_OA3138 = "Thank you again for contacting Acurian's Research Information Center. Goodbye.";
    
    
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText_OA3138;

    public ThankYouCloseSimplePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouCloseSimplePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    
    @Step
    public ThankYouCloseSimplePageOLS waitForOAPageLoad() {
        waitForPageLoadMain(titleText_OA3138, titleExpected_OA3138);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
