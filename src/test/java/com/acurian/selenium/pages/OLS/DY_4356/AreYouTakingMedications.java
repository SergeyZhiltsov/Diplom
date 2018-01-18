package com.acurian.selenium.pages.OLS.DY_4356;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouTakingMedications extends MainPageOLS{

    public final String titleExpected = "Many people are prescribed other kinds of medications to manage high cholesterol, triglycerides, or lipids. They may be taken instead of or in addition to a statin.\n" + 
    		" Are you currently taking any of the following medications on a daily basis? \n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public AreYouTakingMedications() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public AreYouTakingMedications waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public AreYouTakingMedications clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
