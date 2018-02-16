package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DoYouExperienceAnyOfTheFollowingFeelings_OLS extends MainPageOLS{

    public final String titleExpected = "Do you experience any of the following feelings or behaviors when you are having a cluster headache attack?\n" +
    		"Please select all that apply.";
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public DoYouExperienceAnyOfTheFollowingFeelings_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DoYouExperienceAnyOfTheFollowingFeelings_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DoYouExperienceAnyOfTheFollowingFeelings_OLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
