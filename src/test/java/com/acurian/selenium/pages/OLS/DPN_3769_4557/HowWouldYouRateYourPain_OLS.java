package com.acurian.selenium.pages.OLS.DPN_3769_4557;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.shared.StudyQuestionMigPageCC;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.MetforminMedicationsPageOLS;

import ru.yandex.qatools.allure.annotations.Step;


public class HowWouldYouRateYourPain_OLS extends MainPageOLS {

   public final String titleExpected ="How would you rate your pain or discomfort on a scale of 0 to 10?\n" +
"0 means no pain or discomfort at all, and 10 is the worst pain or discomfort you can imagine.";
   
   @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
   WebElement titleText;

    @FindBy(xpath = "//select[@id='QS5510']")
    WebElement painSelect;


    public HowWouldYouRateYourPain_OLS() {
        PageFactory.initElements(getDriver(), this);
    }


    @Step
    public HowWouldYouRateYourPain_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    
    @Step
    public String getTitleText() {
        return getText(titleText);
    }


    @Step
    public HowWouldYouRateYourPain_OLS selectPainRating(String rating) {
        selectDropDownListOptionByText(painSelect, rating);
        return this;
    }
	

}