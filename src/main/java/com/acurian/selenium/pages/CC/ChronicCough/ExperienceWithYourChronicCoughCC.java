package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class ExperienceWithYourChronicCoughCC extends MainPageCC{

    public final String titleExpected = "Which of the following do you experience with your chronic cough?\n" +
    		"Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkbox_container']//span")
    List<WebElement> checkBoxList;

    public ExperienceWithYourChronicCoughCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ExperienceWithYourChronicCoughCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ExperienceWithYourChronicCoughCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
