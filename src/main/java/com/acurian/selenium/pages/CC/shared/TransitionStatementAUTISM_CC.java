package com.acurian.selenium.pages.CC.shared;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

public class TransitionStatementAUTISM_CC extends MainPageCC {

    //%s = studyName variable
    private final String titleExpected = "Thank you for answering the questions about your Autism.\n" +
    		"I am going to ask you several questions about your general medical history which are important for us to know to match you with a study. After each item on the list, please simply tell me \"yes\" or \"no,\" and I will check off each condition that you do have.\n" +
    		"Agent note: If \"no\" to all items in a question, select \"None of the above\"";
    
    @FindBy(xpath = "//div[@class='question_text']")
    WebElement titleText;

    public TransitionStatementAUTISM_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public TransitionStatementAUTISM_CC waitForPageLoad() {
        waitForAnimation();
        String titleExpectedMod = String.format(titleExpected);
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpectedMod));
        return this;
    }

    
    @Step
    public String getTitleText(){
        return getText(titleText);
    }

    public String getTitleExpected(String studyName){
        return String.format(titleExpected, studyName);
    }


}
