package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;


import ru.yandex.qatools.allure.annotations.Step;

public class DyslipidemiaHealthcarePageOLS extends MainPageOLS{

    public final String titleExpected = "Has a healthcare professional ever told you that you have any of the following?\n" + 
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public DyslipidemiaHealthcarePageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DyslipidemiaHealthcarePageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DyslipidemiaHealthcarePageOLS clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
   
}
