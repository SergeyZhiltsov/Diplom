package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.Diabetes_4356A.TreatingYourDiabetesPageOLS;

import ru.yandex.qatools.allure.annotations.Step;

public class CurrentlyTakeAnyMedicationsTreatMIG extends MainPageOLS{

    public final String titleExpected ="Do you currently take any medications to treat your migraine headaches?\n" + 
    		"Please select all that apply."; 
    
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public CurrentlyTakeAnyMedicationsTreatMIG() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public CurrentlyTakeAnyMedicationsTreatMIG waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }
    

    @Step
    public CurrentlyTakeAnyMedicationsTreatMIG clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
