package com.acurian.selenium.pages.OLS.generalHealth;

import com.acurian.selenium.pages.OLS.Diabetes_4356A.InsulinForYourDiabetesPageOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HeartrelatedMedicalProceduresPageOLS extends MainPageOLS{

    public final String titleExpected = "Have you undergone any of the following heart-related medical procedures?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]/div[@class='show-in-ols']")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public HeartrelatedMedicalProceduresPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HeartrelatedMedicalProceduresPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public HeartrelatedMedicalProceduresPageOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
