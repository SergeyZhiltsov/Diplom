package com.acurian.selenium.pages.CC.MDD_3159;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.Arrays;
import java.util.List;

public class WhichFollowingAntidepressantMedsTakingCC extends MainPageCC{

    public final String titleExpected = "I am going to read to you a list of medications used to treat depression. Please tell me which of these medications you are taking right now to help your depression.\n" +
    		"If you are taking a medication that we have not listed, please let us know.\n" +
    		"\n" +
    		"Agent Notes:\n" +    		
    		"Please read the full list of medications to the respondent\n" +
    		"Select all that apply\n" +
    		"If respondent is not taking any right now, select \"None of the above\"";

    @FindBy(xpath = Locators.BASIC_TITLE_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public WhichFollowingAntidepressantMedsTakingCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichFollowingAntidepressantMedsTakingCC waitForPageLoad() {
        waitForAnimation();
        wait.until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhichFollowingAntidepressantMedsTakingCC clickOnAnswers(String ...answerText) {
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
