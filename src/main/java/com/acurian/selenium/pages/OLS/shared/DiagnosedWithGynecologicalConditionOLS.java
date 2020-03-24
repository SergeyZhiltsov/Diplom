package com.acurian.selenium.pages.OLS.shared;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class DiagnosedWithGynecologicalConditionOLS extends MainPageOLS{
    
    public final String titleExpected = "Has a healthcare professional ever diagnosed you with any of these other women's health conditions?\n" +
            "Please select all that apply.";

    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath = "//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;
    
    public DiagnosedWithGynecologicalConditionOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public DiagnosedWithGynecologicalConditionOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public DiagnosedWithGynecologicalConditionOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }
}
