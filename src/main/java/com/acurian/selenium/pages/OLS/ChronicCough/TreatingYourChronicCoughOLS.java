package com.acurian.selenium.pages.OLS.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.LMG_4686.FollowingMedicationsToPreventOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class TreatingYourChronicCoughOLS extends MainPageOLS{

    public final String titleExpected ="Have you tried treating your chronic cough with prescription or over the counter medication?"; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]")
    List<WebElement> checkBoxList;

    public TreatingYourChronicCoughOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TreatingYourChronicCoughOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public TreatingYourChronicCoughOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
