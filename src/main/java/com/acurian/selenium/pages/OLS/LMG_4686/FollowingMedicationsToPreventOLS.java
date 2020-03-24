package com.acurian.selenium.pages.OLS.LMG_4686;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.generalHealth.HaveYouEverBeenDiagnosedWithAnyOfFollowingHealthCondOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class FollowingMedicationsToPreventOLS extends MainPageOLS{

    public final String titleExpected ="Over the past 10 years, have you ever taken any of the following medications daily or regularly to prevent migraines?\n" +
    		"This includes any medications you are currently taking to prevent migraines.\n" +
    		"Please select all that apply."; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public FollowingMedicationsToPreventOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingMedicationsToPreventOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public FollowingMedicationsToPreventOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }
    

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
