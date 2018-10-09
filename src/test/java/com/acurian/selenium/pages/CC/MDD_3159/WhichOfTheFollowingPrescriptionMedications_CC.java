package com.acurian.selenium.pages.CC.MDD_3159;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;
import com.acurian.selenium.pages.CC.MainPageCC;

public class WhichOfTheFollowingPrescriptionMedications_CC extends MainPageCC{

    public final String titleExpected = "Now, please think about your depression overall, both your current episode and any past episodes of depression.\n" +
    		"Which of the following prescription medications have you ever taken to treat depression?\n" +
    		"\n" +
    		"Agent Notes:\n" +
    		"Please read the full list of medications to the respondent\n" +
    		"Select all that apply\n" +
    		"If respondent has never taken any, select \"None of the above\"";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public WhichOfTheFollowingPrescriptionMedications_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfTheFollowingPrescriptionMedications_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhichOfTheFollowingPrescriptionMedications_CC clickOnAnswers(String ...answerText) {
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.contains(el.getText()))
                .forEach(el -> el.click());
        waitForAnimation();
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
