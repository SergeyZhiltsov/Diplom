package com.acurian.selenium.pages.OLS.MDD_3159;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acurian.selenium.pages.OLS.MainPageOLS;
import ru.yandex.qatools.allure.annotations.Step;

public class WhichFollowingAntidepressantMedicationsYouTriedOLS extends MainPageOLS{

    public final String titleExpected = "Which of the following antidepressant medications have you tried for your current episode of depression, but are NOT currently taking?\n" +
    		"Please select all that apply.";
    		
    @FindBy(xpath = "//div[@class='question']//div[contains(@class,'visible-md-block')]")
    WebElement titleText;

    @FindBy(xpath ="//span[contains(@class,'visible-md-inline')]/span[@class='show-in-ols']")
    List<WebElement> checkBoxList;

    public WhichFollowingAntidepressantMedicationsYouTriedOLS() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichFollowingAntidepressantMedicationsYouTriedOLS waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public WhichFollowingAntidepressantMedicationsYouTriedOLS clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText() {
        return getText(titleText);
    }

}
