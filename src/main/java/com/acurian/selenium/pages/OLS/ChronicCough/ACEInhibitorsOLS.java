package com.acurian.selenium.pages.OLS.ChronicCough;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class ACEInhibitorsOLS extends MainPageOLS{

    public final String titleExpected ="ACE inhibitors are medications commonly used to treat high blood pressure (hypertension) and heart failure. This medication is also used for some forms of kidney disease in diabetics, as well as to help protect the heart after heart attacks.\n" +
    		"In the past 3 months, have you taken any of the following ACE Inhibitors?\n" +
    		"Please select all that apply."; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//span[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public ACEInhibitorsOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ACEInhibitorsOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public ACEInhibitorsOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
