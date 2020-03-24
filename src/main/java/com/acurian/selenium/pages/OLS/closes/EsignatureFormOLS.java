package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class EsignatureFormOLS extends MainPageOLS{

    public final String titleExpected = "If the e-signature form did not appear or if you were unable to complete the Medical Record Release process please do not worry.\n" +
            "\n" +
    		"We will contact you if additional information is needed.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    

    public EsignatureFormOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public EsignatureFormOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
