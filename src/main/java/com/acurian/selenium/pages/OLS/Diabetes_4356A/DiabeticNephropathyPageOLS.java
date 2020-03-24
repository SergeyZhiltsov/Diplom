package com.acurian.selenium.pages.OLS.Diabetes_4356A;

import com.acurian.selenium.pages.OLS.MainPageOLS;
import com.acurian.selenium.pages.OLS.shared.ProcedureForWeightLossPageOLS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class DiabeticNephropathyPageOLS extends MainPageOLS{

    public final String titleExpected = "Do you have kidney disease caused by diabetes, also known as diabetic nephropathy?";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/ancestor::label")
    List<WebElement> radioButtonsList;

    public DiabeticNephropathyPageOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiabeticNephropathyPageOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiabeticNephropathyPageOLS clickOnAnswer(String answerText) {
        clickOnRadioButton(radioButtonsList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
