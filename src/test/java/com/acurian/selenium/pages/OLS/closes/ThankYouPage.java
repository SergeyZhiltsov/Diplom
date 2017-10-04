package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ThankYouPage extends MainPageOLS{

    public final String titleExpected = "Thank you. Clinical research studies greatly contribute to the overall progress in understanding and finding future treatments for diseases and we appreciate your interest in participation.";
            

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    

    public ThankYouPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ThankYouPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
