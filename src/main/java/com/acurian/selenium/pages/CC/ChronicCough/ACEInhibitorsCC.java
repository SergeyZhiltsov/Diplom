package com.acurian.selenium.pages.CC.ChronicCough;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acurian.selenium.pages.CC.MainPageCC;

import ru.yandex.qatools.allure.annotations.Step;

public class ACEInhibitorsCC extends MainPageCC{

    public final String titleExpected = "ACE inhibitors are medications commonly used to treat high blood pressure (hypertension) and heart failure. This medication is also used for some forms of kidney disease in diabetics, as well as to help protect the heart after heart attacks.\n" +
    		"In the past 3 months, have you taken any of the following ACE Inhibitors?\n" +
    		"Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkbox_container']//span")
    List<WebElement> checkBoxList;

    public ACEInhibitorsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public ACEInhibitorsCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public ACEInhibitorsCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }

}
