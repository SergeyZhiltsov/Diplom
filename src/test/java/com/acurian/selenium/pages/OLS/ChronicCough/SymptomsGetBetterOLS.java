package com.acurian.selenium.pages.OLS.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.OLS.MainPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class SymptomsGetBetterOLS extends MainPageOLS{

    public final String titleExpected ="Do any of these symptoms get better when you take medication?\n" +
    		"Please select all that apply."; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//span[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public SymptomsGetBetterOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public SymptomsGetBetterOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public SymptomsGetBetterOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
