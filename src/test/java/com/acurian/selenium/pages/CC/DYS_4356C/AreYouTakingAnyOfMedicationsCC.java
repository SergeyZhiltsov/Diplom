package com.acurian.selenium.pages.CC.DYS_4356C;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.acurian.selenium.pages.CC.MainPageCC;
import ru.yandex.qatools.allure.annotations.Step;

public class AreYouTakingAnyOfMedicationsCC extends MainPageCC {

    public final String titleExpected = "Many people are prescribed other kinds of medications to manage high cholesterol, triglycerides, or lipids. They may be taken instead of or in addition to a statin. \n" +
            "Are you currently taking any of the following medications on a daily basis? \n" +
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public AreYouTakingAnyOfMedicationsCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public  AreYouTakingAnyOfMedicationsCC waitForPageLoad() {
        waitForAnimation();       
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public AreYouTakingAnyOfMedicationsCC clickOnAnswers(String ...answerText) {
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
