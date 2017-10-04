package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class StatinMedicationsPage extends MainPageOLS{

    public final String titleExpected = "One of the most common kinds of medicines to manage high cholesterol, triglycerides, or lipids is a medicine called a statin. Most people with\n" + 
    		"these conditions are prescribed this kind of medicine for their condition. Statins are prescribed in many different names.\n" +
    		"Are you currently taking any of the following statin medications on a daily basis?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[contains(@class,'visible-md-block')]//div[contains(@class,'show-in-ols')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public StatinMedicationsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public StatinMedicationsPage waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public StatinMedicationsPage clickOnAnswers(String answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
