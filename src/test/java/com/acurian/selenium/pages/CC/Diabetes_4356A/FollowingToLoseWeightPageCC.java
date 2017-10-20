package com.acurian.selenium.pages.CC.Diabetes_4356A;

import com.acurian.selenium.constants.Locators;
import com.acurian.selenium.pages.CC.MainPageCC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class FollowingToLoseWeightPageCC extends MainPageCC{

    public final String titleExpected = "Are you currently using any of the following to lose weight?";

    @FindBy(xpath = Locators.BASIC_TITLE2_WITH_CHECKBOXES_BUTTON_CC)
    WebElement titleText;

    @FindBy(xpath = Locators.CHEKBOX_LIST2_CC)
    List<WebElement> checkBoxList;

    public FollowingToLoseWeightPageCC() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step
    public FollowingToLoseWeightPageCC waitForPageLoad() {
        waitForPageLoadMain(titleText, titleExpected);
        return this;
    }

    @Step
    public FollowingToLoseWeightPageCC clickOnAnswers(String ...answerText) {
        clickOnCheckBoxes(checkBoxList, answerText);
        return this;
    }

    protected void clickOnCheckBoxes(List<WebElement> checkBoxList, String ...answerText){
        List<String> answerTextList = Arrays.asList(answerText);
        checkBoxList.stream().filter(el -> answerTextList.parallelStream().anyMatch(el.getText()::contains))
                .forEach(el -> el.click());
        waitForAnimation();
    }

    @Step
    public String getTitleText(){
        return getText(titleText);
    }
}
