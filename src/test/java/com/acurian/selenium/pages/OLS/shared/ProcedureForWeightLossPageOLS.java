package com.acurian.selenium.pages.OLS.shared;

import com.acurian.selenium.pages.OLS.Diabetes_4356A.CombinationWithEachOtherPageOLS;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ProcedureForWeightLossPageOLS extends MainPageOLS{

    public final String titleExpected = "When was the last time that you had a surgery or medical procedure for weight loss?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public ProcedureForWeightLossPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ProcedureForWeightLossPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ProcedureForWeightLossPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
