package com.acurian.selenium.pages.OLS.closes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class GladLocationIsConvenient extends MainPageOLS{

    public final String titleExpected = "We're glad the location is convenient for you.\n" +
            "We will forward your contact information to the doctor's office that you selected so they may contact you.";

    @FindBy(xpath = "//div[@class='ng-scope']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;
    

    public GladLocationIsConvenient() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public GladLocationIsConvenient waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }
    
   
}
