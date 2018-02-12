package com.acurian.selenium.pages.CC.DPN_3769_4557;

import com.acurian.selenium.constants.Locators;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class HowWouldYouDescribeTheSymptoms_CC extends MainPageCC{

    public final String titleExpected = "How would you describe the symptoms or sensations you feel in your feet, legs, hands, or arms?\n"+
            "Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public HowWouldYouDescribeTheSymptoms_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public HowWouldYouDescribeTheSymptoms_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public HowWouldYouDescribeTheSymptoms_CC clickOnAnswers(String ...answerText) {
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