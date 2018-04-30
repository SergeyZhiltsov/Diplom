package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AgeUnqualifiedClose_OLS extends MainPageOLS{

    public final String titleExpected = "We certainly appreciate your interest in clinical trials. Unfortunately, we cannot ask you any health-related questions because you are under 18 years old. If you are interested in pre-screening for a study, please ask your parent or guardian to call back and provide information on your behalf.";
            

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;
    

    public AgeUnqualifiedClose_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AgeUnqualifiedClose_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
