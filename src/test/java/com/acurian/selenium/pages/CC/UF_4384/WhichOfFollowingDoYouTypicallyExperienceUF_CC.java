package com.acurian.selenium.pages.CC.UF_4384;

import com.acurian.selenium.constants.Locators;

import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class WhichOfFollowingDoYouTypicallyExperienceUF_CC extends MainPageCC{

    public final String titleExpected = "Heavy menstrual bleeding often affects a woman's quality of life.\n"+
"Which of the following do you typically experience during your period?\n"+
"Agent Note: Select all that apply";

    @FindBy(xpath = "//div[@class='question_text']//div[@class='show-in-cc']")
    WebElement titleText;

    @FindBy(xpath = "//div[@class='checkboxes_container']//span[@class='show-in-cc']")
    List<WebElement> checkBoxList;

    public WhichOfFollowingDoYouTypicallyExperienceUF_CC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public WhichOfFollowingDoYouTypicallyExperienceUF_CC waitForPageLoad() {
        waitForAnimation();
        driverWait.getWaitDriver().until((ExpectedCondition<Boolean>) w-> titleText.getText().contains(titleExpected));
        return this;
    }

    @Step
    public WhichOfFollowingDoYouTypicallyExperienceUF_CC clickOnAnswers(String ...answerText) {
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
