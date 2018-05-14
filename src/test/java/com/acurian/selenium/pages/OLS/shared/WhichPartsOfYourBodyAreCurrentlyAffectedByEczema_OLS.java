package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS extends MainPageOLS{

    public final String titleExpected ="Which parts of your body are currently affected by eczema (atopic dermatitis)?"; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public WhichPartsOfYourBodyAreCurrentlyAffectedByEczema_OLS clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
